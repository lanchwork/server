package com.seal.ljk.service.impl

import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.IdNotFoundException
import com.seal.ljk.base.SealException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.SysDictUtil
import com.seal.ljk.common.getSessionUser
import com.seal.ljk.dao.SysPartnerMapper
import com.seal.ljk.model.SysPartner
import com.seal.ljk.model.SysUser
import com.seal.ljk.service.ISysPartnerService
import com.seal.ljk.service.ISysUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * <p>
 * 合作方表 服务实现类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-24
 */
@Service
class SysPartnerServiceImpl : ISysPartnerService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var sysPartnerMapper: SysPartnerMapper
    @Autowired
    lateinit var sysUserService: ISysUserService

    override fun getSysPartner(id: String): SysPartner {
        return sysPartnerMapper.get(id) ?: throw IdNotFoundException()
    }

    override fun getByChannelMark(channelMark: String): SysPartner? {
        return sysPartnerMapper.getByChannelMark(channelMark)
    }

    override fun getAllSysPartner(sysPartner: SysPartner): List<SysPartner> {
        return sysPartnerMapper.getAll(sysPartner)
    }

    override fun getAllSysPartnerByPage(sysPartner: SysPartner): Page<SysPartner> {
        val user = getSessionUser() ?: throw AuthException()
        if (!user.isSeal()) {
            sysPartner.channelMark = user.channelMark
        }
        return sysPartnerMapper.getAllByPage(sysPartner)
    }

    override fun insertSysPartner(sysPartner: SysPartner) {
        val user = getSessionUser() ?: throw AuthException()
        if (!user.isSeal()) {
            throw SealException(message = "权限不足")
        }
        sysPartner.partnerType = "1"
        sysPartnerMapper.insert(sysPartner)
        // 添加合作方同时添加管理员账户
        sysUserService.insertSysUser(SysUser(username = "admin", initPass = "${sysPartner.channelMark}@2018", channelMark = sysPartner.channelMark, name = "管理员", openFlag = "1", userType = "1"))

//        更新缓存
        SysDictUtil.addSysPartner(sysPartner)

    }

    override fun updateSysPartner(sysPartner: SysPartner) {
        val user = getSessionUser() ?: throw AuthException()
        if (!user.isSeal()) {
            throw SealException(message = "权限不足")
        }
        sysPartnerMapper.update(sysPartner)
//        更新缓存
        SysDictUtil.updateSysPartner(sysPartner)
    }

    override fun deleteSysPartner(id: String) {
        throw SealException(message = "合作方不允许删除")
//        sysPartnerMapper.delete(id)
    }

}
