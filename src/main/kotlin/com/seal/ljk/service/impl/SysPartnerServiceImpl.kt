package com.seal.ljk.service.impl

import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser
import com.seal.ljk.dao.SysPartnerMapper
import com.seal.ljk.model.SysPartner
import com.seal.ljk.service.ISysPartnerService
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
@Service(value = "sysPartnerService")
class SysPartnerServiceImpl : ISysPartnerService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var sysPartnerMapper: SysPartnerMapper

    override fun getSysPartner(id: String): SysPartner {
        return sysPartnerMapper.get(id)
    }

    override fun getAllSysPartner(sysPartner: SysPartner): Page<SysPartner> {
        val user = getSessionUser() ?: throw AuthException()
        if (user.isSeal()) {
           sysPartner.channelMark = ""
        } else {
           sysPartner.channelMark = user.channelMark
        }
        return sysPartnerMapper.getAll(sysPartner)
    }

    override fun insertSysPartner(sysPartner: SysPartner) {
        sysPartnerMapper.insert(sysPartner)
    }

    override fun updateSysPartner(sysPartner: SysPartner) {
        sysPartnerMapper.update(sysPartner)
    }

    override fun deleteSysPartner(id: String) {
        sysPartnerMapper.delete(id)
    }

}
