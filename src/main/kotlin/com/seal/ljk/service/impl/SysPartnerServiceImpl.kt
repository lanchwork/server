package com.seal.ljk.service.impl

import com.seal.ljk.model.SysPartner
import com.seal.ljk.dao.SysPartnerMapper
import com.seal.ljk.service.ISysPartnerService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.common.UUIDUtil

/**
 * <p>
 * 合作方表 服务实现类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-24
 */
@Service(value = "sysPartnerService")
open class SysPartnerServiceImpl : ISysPartnerService {

    @Autowired
    lateinit var mapper: SysPartnerMapper

    override fun get(id: String): SysPartner {
        return mapper.get(id)
    }

    override fun getAll(data: SysPartner): Page<SysPartner> {
        return mapper.getAll(data)
    }

    override fun insert(data: SysPartner) {
        if(data.id == ""){
            data.id = UUIDUtil.uuid
        }
        mapper.insert(data)
    }

    override fun update(data: SysPartner) {
        mapper.update(data)
    }

    override fun delete(id: String) {
        mapper.delete(id)
    }

}
