package com.seal.ljk.service.impl

import com.seal.ljk.model.TzMessageInfo
import com.seal.ljk.dao.TzMessageInfoDao
import com.seal.ljk.service.ITzMessageInfoService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.IdNotFoundException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lanch
 * @since 2019-01-16
 */
@Service
class TzMessageInfoServiceImpl : ITzMessageInfoService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var tzMessageInfoDao: TzMessageInfoDao

    override fun getTzMessageInfo(id: String): TzMessageInfo? {
        return tzMessageInfoDao.get(id) ?: throw IdNotFoundException()
    }

    override fun getAllTzMessageInfo(tzMessageInfo: TzMessageInfo): List<TzMessageInfo> {
        return tzMessageInfoDao.getAll(tzMessageInfo)
    }

    override fun getAllTzMessageInfoByPage(tzMessageInfo: TzMessageInfo): Page<TzMessageInfo> {
        return tzMessageInfoDao.getAllByPage(tzMessageInfo)
    }

    override fun insertTzMessageInfo(tzMessageInfo: TzMessageInfo) {
        tzMessageInfoDao.insert(tzMessageInfo)
    }

    override fun updateTzMessageInfo(tzMessageInfo: TzMessageInfo) {
        tzMessageInfoDao.update(tzMessageInfo)
    }

    override fun deleteTzMessageInfo(id: String) {
        tzMessageInfoDao.delete(id)
    }

}
