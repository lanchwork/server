package com.seal.ljk.service.impl

import com.seal.ljk.model.TzInvestItem
import com.seal.ljk.dao.TzInvestItemDao
import com.seal.ljk.service.ITzInvestItemService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser

/**
 * <p>
 * 投资项目 服务实现类
 * </p>
 *
 * @author kangxj
 * @since 2018-12-28
 */
@Service
class TzInvestItemServiceImpl : ITzInvestItemService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var tzInvestItemDao: TzInvestItemDao

    override fun getTzInvestItem(id: String): TzInvestItem? {
        return tzInvestItemDao.get(id)
    }

    override fun getAllTzInvestItem(tzInvestItem: TzInvestItem): List<TzInvestItem> {
        return tzInvestItemDao.getAll(tzInvestItem)
    }

    override fun getAllTzInvestItemByPage(tzInvestItem: TzInvestItem): Page<TzInvestItem> {
        return tzInvestItemDao.getAllByPage(tzInvestItem)
    }

    override fun insertTzInvestItem(tzInvestItem: TzInvestItem) {
        tzInvestItemDao.insert(tzInvestItem)
    }

    override fun updateTzInvestItem(tzInvestItem: TzInvestItem) {
        tzInvestItemDao.update(tzInvestItem)
    }

    override fun deleteTzInvestItem(id: String) {
        tzInvestItemDao.delete(id)
    }

}
