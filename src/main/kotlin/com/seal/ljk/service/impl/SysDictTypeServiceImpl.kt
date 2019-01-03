package com.seal.ljk.service.impl

import com.seal.ljk.model.SysDictType
import com.seal.ljk.dao.SysDictTypeDao
import com.seal.ljk.service.ISysDictTypeService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser

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

    override fun getSysDictType(id: String): SysDictType? {
        return sysDictTypeDao.get(id)
    }

    override fun getAllSysDictType(sysDictType: SysDictType): List<SysDictType> {
        return sysDictTypeDao.getAll(sysDictType)
    }

    override fun getAllSysDictTypeByPage(sysDictType: SysDictType): Page<SysDictType> {
        return sysDictTypeDao.getAllByPage(sysDictType)
    }

    override fun insertSysDictType(sysDictType: SysDictType) {
        sysDictTypeDao.insert(sysDictType)
    }

    override fun updateSysDictType(sysDictType: SysDictType) {
        sysDictTypeDao.update(sysDictType)
    }

    override fun deleteSysDictType(id: String) {
        sysDictTypeDao.delete(id)
    }

}
