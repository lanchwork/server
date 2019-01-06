package com.seal.ljk.service.impl

import com.seal.ljk.model.SysBanner
import com.seal.ljk.dao.SysBannerDao
import com.seal.ljk.service.ISysBannerService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.SealException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser

/**
 * <p>
 * banner 服务实现类
 * </p>
 *
 * @author lanch
 * @since 2019-01-03
 */
@Service
class SysBannerServiceImpl : ISysBannerService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var sysBannerDao: SysBannerDao

    override fun getSysBanner(id: String): SysBanner {
        return sysBannerDao.get(id) ?: throw SealException(message = "id 数据项不存在。")
    }

    override fun getAllSysBanner(sysBanner: SysBanner): List<SysBanner> {
        return sysBannerDao.getAll(sysBanner)
    }

    override fun getAllSysBannerByPage(sysBanner: SysBanner): Page<SysBanner> {
        return sysBannerDao.getAllByPage(sysBanner)
    }

    override fun insertSysBanner(sysBanner: SysBanner) {
        sysBannerDao.insert(sysBanner)
    }

    override fun updateSysBanner(sysBanner: SysBanner) {
        sysBannerDao.update(sysBanner)
    }

    override fun deleteSysBanner(id: String) {
        sysBannerDao.delete(id)
    }

}
