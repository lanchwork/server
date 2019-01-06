package com.seal.ljk.service.impl

import com.seal.ljk.model.TzInvestInfo
import com.seal.ljk.dao.TzInvestInfoDao
import com.seal.ljk.service.ITzInvestInfoService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.SealException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser

/**
 * <p>
 * 投资信息 服务实现类
 * </p>
 *
 * @author lanch
 * @since 2018-12-28
 */
@Service
class TzInvestInfoServiceImpl : ITzInvestInfoService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var tzInvestInfoDao: TzInvestInfoDao

    override fun getTzInvestInfo(id: String): TzInvestInfo {
        return tzInvestInfoDao.get(id) ?: throw SealException(message = "id 数据项不存在。")
    }

    override fun getAllTzInvestInfo(tzInvestInfo: TzInvestInfo): List<TzInvestInfo> {
        return tzInvestInfoDao.getAll(tzInvestInfo)
    }

    override fun getAllTzInvestInfoByPage(tzInvestInfo: TzInvestInfo): Page<TzInvestInfo> {
        return tzInvestInfoDao.getAllByPage(tzInvestInfo)
    }

    override fun insertTzInvestInfo(tzInvestInfo: TzInvestInfo) {
        tzInvestInfoDao.insert(tzInvestInfo)
    }

    override fun updateTzInvestInfo(tzInvestInfo: TzInvestInfo) {
        tzInvestInfoDao.update(tzInvestInfo)
    }

    override fun deleteTzInvestInfo(id: String) {}

}
