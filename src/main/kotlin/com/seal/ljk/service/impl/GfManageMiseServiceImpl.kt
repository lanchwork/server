package com.seal.ljk.service.impl

import com.github.pagehelper.Page
import com.seal.ljk.base.IdNotFoundException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.dao.GfManageMiseDao
import com.seal.ljk.model.GfManageMise
import com.seal.ljk.service.IGfManageMiseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * <p>
 * 管理员服务实现类
 * </p>
 *
 * @author kangxj
 * @since 2019-01-04
 */
@Service
class GfManageMiseServiceImpl : IGfManageMiseService {


    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var gfManageMiseDao: GfManageMiseDao

    override fun getGfManageMise(id: String): GfManageMise {
        return gfManageMiseDao.get(id) ?: throw IdNotFoundException()
    }

    override fun getAllGfManageMise(gfManageMise: GfManageMise): List<GfManageMise> {
        return gfManageMiseDao.getAll(gfManageMise)
    }

    override fun getAllGfManageMiseByPage(gfManageMise: GfManageMise): Page<GfManageMise> {
        return gfManageMiseDao.getAllByPage(gfManageMise)
    }

    override fun insertGfManageMise(gfManageMise: GfManageMise) {
        gfManageMiseDao.insert(gfManageMise)
    }

    override fun updateGfManageMise(gfManageMise: GfManageMise) {
        gfManageMiseDao.update(gfManageMise)
    }

    override fun deleteGfManageMise(id: String) {
        gfManageMiseDao.delete(id)
    }
    override fun addressExist(address: String): Int {
        return gfManageMiseDao.isExietAddress(address)
    }

}
