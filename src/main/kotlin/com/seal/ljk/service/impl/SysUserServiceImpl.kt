package com.seal.ljk.service.impl

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.github.pagehelper.Page
import com.seal.ljk.base.*
import com.seal.ljk.common.*
import com.seal.ljk.dao.SysUserMapper
import com.seal.ljk.model.SysUser
import com.seal.ljk.service.ISysPartnerService
import com.seal.ljk.service.ISysUserRoleService
import com.seal.ljk.service.ISysUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

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
    @Autowired
    lateinit var sysUserRoleService: ISysUserRoleService


    override fun getSysUser(id: String): SysUser {
        return sysUserMapper.get(id) ?: throw IdNotFoundException()
    }

    override fun getAllSysUser(sysUser: SysUser): List<SysUser> {
        val user = getSessionUser() ?: throw AuthException()
        if (!user.isSeal()) {
            sysUser.channelMark = user.channelMark
        }
        return sysUserMapper.getAll(sysUser)
    }

    override fun getAllSysUserByPage(sysUser: SysUser): Page<SysUser> {
        val user = getSessionUser() ?: throw AuthException()
        if (!user.isSeal()) {
            sysUser.userType = "2"
            sysUser.channelMark = user.channelMark
        } else {
            sysUser.userTypes = arrayOf("1", "2")
        }
        val list = sysUserMapper.getAllByPage(sysUser)
        if (list.isNotEmpty()) {
            val userRoleMap = sysUserRoleService.findRoleNameByUserId(list.map { it.id }.toTypedArray())
                    .map { it.userId to it.roleName }.toMap()

            list.forEach {
                it.userTypeName = SysDictUtil.findType("userType", it.userType)
                if (it.userType == "2") {
                    it.userTypeName = userRoleMap[it.id]
                }
            }
        }
        return list
    }

    override fun insertSysUser(sysUser: SysUser) {
        val user = getSessionUser() ?: throw AuthException()

        if (sysUser.channelMark.isEmpty()) {
            sysUser.channelMark = user.channelMark
        }

        if (sysUser.userType == "0" || sysUser.userType == "1") {//管理员账户
            if (!user.isSeal()) {
                throw SealException(message = "权限不足，无法新增管理员")
            }
        }
        if (sysUser.initPass.isNotEmpty()) {
            sysUser.password = MessageDigestUtil.md5Pass(sysUser.initPass)
        }

        sysUserMapper.getUser(sysUser.channelMark, sysUser.username)?.apply {
            throw SealException(message = "合作方【${sysUser.channelMark}】下用户名【${sysUser.username}】已存在")
        }
        sysUserMapper.insert(sysUser)
    }

    override fun updateSysUser(sysUser: SysUser) {
        if (sysUser.initPass.isNotEmpty()) {
            sysUser.password = MessageDigestUtil.md5Pass(sysUser.initPass)
        }
        sysUserMapper.update(sysUser)
    }

    override fun deleteSysUser(id: String) {
        val sysUser = getSysUser(id)
        val user = getSessionUser() ?: throw AuthException()

        if (sysUser.userType == "0") {//管理员账户
            if (!user.isSeal()) {
                throw SealException(message = "权限不足，无法删除管理员")
            }
        }
        sysUserMapper.delete(id)
    }

    override fun changePass(oldPass: String, newPass: String) {
        checkParam(oldPass, newPass)
        val user = getSessionUser() ?: throw AuthException()
        if (!user.password.equals(MessageDigestUtil.md5Pass(oldPass), true)) {
            throw SealException("原密码不正确。")
        }
        updateSysUser(SysUser(id = user.id, password = MessageDigestUtil.md5Pass(newPass)))
    }

    override fun login(channelMark: String, userName: String, password: String): Map<String, Any> {
        val partner = sysPartnerService.getByChannelMark(channelMark)
                ?: throw SealException(message = "合作方不存在。")
        if (partner.openFlag != "1") {
            throw SealException(message = "该合作方已被禁用，请联系管理员。")
        }
        val user = sysUserMapper.getUser(channelMark, userName)
                ?: throw SealException(message = "该用户不存在。")
        if (!user.password.equals(MessageDigestUtil.md5Pass(password), true)) {
            throw SealException(message = "密码错误。")
        }
        if (user.openFlag != "1") {
            throw SealException(message = "该用户已被禁用，请联系管理员。")
        }
        val token = getUserToken(user)

        user.partner = partner

//        val menuList = sysMenuService.getAllSysMenuByUser(user)

        return mapOf(
                "token" to token
//                "username" to user.username,
//                "channelMark" to user.channelMark,
//                "phone" to user.phone,
//                "email" to user.email
//                "menuList" to menuList
        )
    }

    override fun getUserToken(user: SysUser): String {
        //todo 后续需要处理下加密问题
        return JWT.create().withAudience(user.id)
                .withIssuedAt(Date())
                .sign(Algorithm.HMAC256(Constant.SEAL_SALT))
    }

    override fun verifyUser(token: String?): SysUser {
        if (token == null) {
            throw  ParamException()
        }

        try {
            val userId = JWT.decode(token).audience[0]
            // 验证 token
            val jwtVerifier = JWT.require(Algorithm.HMAC256(Constant.SEAL_SALT)).build()
            jwtVerifier.verify(token)
            val sysUser = getSysUser(userId)
            val partner = sysPartnerService.getByChannelMark(sysUser.channelMark)
                    ?: throw SealException(message = "合作方不存在。")
            sysUser.partner = partner
            return sysUser
        } catch (e: Exception) {
            throw  AuthException()
        }
    }

}
