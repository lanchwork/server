package com.seal.ljk.service.impl

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTDecodeException
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.ParamException
import com.seal.ljk.base.SealException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.Constant
import com.seal.ljk.common.MessageDigetUtil
import com.seal.ljk.common.checkParam
import com.seal.ljk.common.getSessionUser
import com.seal.ljk.dao.SysUserMapper
import com.seal.ljk.model.SysPartner
import com.seal.ljk.model.SysUser
import com.seal.ljk.service.ISysPartnerService
import com.seal.ljk.service.ISysUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-25
 */
@Service
class SysUserServiceImpl : ISysUserService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var sysUserMapper: SysUserMapper
    @Autowired
    lateinit var sysPartnerService: ISysPartnerService


    override fun getSysUser(id: String): SysUser {
        return sysUserMapper.get(id)
    }

    override fun getAllSysUser(sysUser: SysUser): Page<SysUser> {
        val user = getSessionUser() ?: throw AuthException()
        if (user.isSeal()) {
            sysUser.channelMark = ""
        } else {
            sysUser.channelMark = user.channelMark
        }
        return sysUserMapper.getAll(sysUser)
    }

    override fun insertSysUser(sysUser: SysUser) {
        if (sysUser.initPass.isNotEmpty()) {
            sysUser.password = MessageDigetUtil.md5Pass(sysUser.initPass)
        }
        sysUserMapper.insert(sysUser)
    }

    override fun updateSysUser(sysUser: SysUser) {
        sysUserMapper.update(sysUser)
    }

    override fun deleteSysUser(id: String) {
        sysUserMapper.delete(id)
    }

    override fun changePass(oldPass: String, newPass: String) {
        checkParam(oldPass, newPass)
        val user = getSessionUser() ?: throw AuthException()
        if (!user.password.equals(oldPass, true)) {
            throw SealException("原密码不正确。")
        }
        updateSysUser(SysUser(id = user.id, password = newPass))
    }

    override fun login(channelMark: String, userName: String, password: String): Map<String, Any> {
        val partner = sysPartnerService.getByChannelMark(channelMark)
                ?: throw SealException(message = "合作方不存在。")
        if (partner.openFlag != "1") {
            throw SealException(message = "该合作方已被禁用，请管理员。")
        }
        val user = sysUserMapper.getUser(channelMark, userName)
                ?: throw SealException(message = "该用户不存在。")
        if (!user.password.equals(password, true)) {
            throw SealException(message = "密码错误。")
        }
        if (user.openFlag != "1") {
            throw SealException(message = "该用户已被禁用，请管理员。")
        }
        val token = getUserToken(user)

        partner.walletAddr = null
        user.password = ""
        user.initPass = ""

        //todo 查询首页权限并返回

        return mapOf(
                "partner" to partner,
                "user" to user,
                "token" to token
        )
    }

    override fun getUserToken(user: SysUser): String {
        return JWT.create().withAudience(user.id)
                .sign(Algorithm.HMAC256(Constant.SEAL_SALT))
    }

    override fun verifyUser(token: String?): SysUser {
        if (token == null) {
            throw  ParamException()
        }
        // 获取 token 中的 user id
        val userId: String
        try {
            userId = JWT.decode(token).audience[0]
        } catch (j: JWTDecodeException) {
            throw  AuthException()
        }

        val user = getSysUser(userId)
        // 验证 token
        val jwtVerifier = JWT.require(Algorithm.HMAC256(Constant.SEAL_SALT)).build()

        try {
            jwtVerifier.verify(token)
        } catch (e: Exception) {
            throw  AuthException()
        }
        return user

    }

}
