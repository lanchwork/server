package com.seal.ljk.service.impl

import com.seal.ljk.model.TzAgencyHold
import com.seal.ljk.dao.TzAgencyHoldDao
import com.seal.ljk.service.ITzAgencyHoldService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.SealException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser

/**
 * <p>
 * 代持服务实现类
 * </p>
 *
 * @author kangxj
 * @since 2019-01-02
 */
@Service
class TzAgencyHoldServiceImpl : ITzAgencyHoldService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var tzAgencyHoldDao: TzAgencyHoldDao

    override fun getTzAgencyHold(id: String): TzAgencyHold {
        return tzAgencyHoldDao.get(id) ?: throw SealException(message = "id 数据项不存在。")
    }

    override fun getAllTzAgencyHold(tzAgencyHold: TzAgencyHold): List<TzAgencyHold> {
        return tzAgencyHoldDao.getAll(tzAgencyHold)
    }

    override fun getAllTzAgencyHoldByPage(tzAgencyHold: TzAgencyHold): Page<TzAgencyHold> {
        return tzAgencyHoldDao.getAllByPage(tzAgencyHold)
    }

    override fun insertTzAgencyHold(tzAgencyHold: TzAgencyHold) {
        tzAgencyHoldDao.insert(tzAgencyHold)
    }

    override fun updateTzAgencyHold(tzAgencyHold: TzAgencyHold) {
        tzAgencyHoldDao.update(tzAgencyHold)
    }

    override fun deleteTzAgencyHold(id: String) {
        tzAgencyHoldDao.delete(id)
    }

    override fun queryConditionsTzAgencyHoldByPage(tzAgencyHold: TzAgencyHold): Page<TzAgencyHold> {
        return tzAgencyHoldDao.queryConditionsTzAgencyHoldByPage(tzAgencyHold)
    }

}
