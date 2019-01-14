package com.seal.ljk.service.impl

import com.github.pagehelper.Page
import com.seal.ljk.base.IdNotFoundException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.SysDictUtil
import com.seal.ljk.dao.SysDictTypeDao
import com.seal.ljk.model.SysDictType
import com.seal.ljk.model.SysPartner
import com.seal.ljk.service.ISysDictTypeService
import com.seal.ljk.service.ISysPartnerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * <p>
 * 数据字典类型 服务实现类
 * </p>
 *
 * @author tingyx
 * @since 2019-01-03
 */
@Service
class SysDictTypeServiceImpl : ISysDictTypeService {

    val log = loggerFor(this.javaClass)


    @Autowired
    lateinit var sysDictTypeDao: SysDictTypeDao
    @Autowired
    lateinit var sysPartnerService: ISysPartnerService

    override fun getSysDictType(id: String): SysDictType {
        return sysDictTypeDao.get(id) ?: throw IdNotFoundException()
    }

    override fun getAllSysDictType(sysDictType: SysDictType): List<SysDictType> {
        return sysDictTypeDao.getAll(sysDictType)
    }

    override fun getAllSysDictTypeByPage(sysDictType: SysDictType): Page<SysDictType> {
        return sysDictTypeDao.getAllByPage(sysDictType)
    }

    override fun insertSysDictType(sysDictType: SysDictType) {
        sysDictTypeDao.insert(sysDictType)
        refreshCache()
    }

    override fun updateSysDictType(sysDictType: SysDictType) {
        sysDictTypeDao.update(sysDictType)
        refreshCache()
    }

    override fun deleteSysDictType(id: String) {
        sysDictTypeDao.delete(id)
        refreshCache()
    }

    override fun getAllSysDict(): List<Map<String, String>> {
        return sysDictTypeDao.getAllSysDict()
    }

    override fun refreshCache() {
        val sysDictTypes = getAllSysDict()
        SysDictUtil.initDict(sysDictTypes)
        val partners = sysPartnerService.getAllSysPartner(SysPartner())
        SysDictUtil.initPartner(partners)
    }

}
