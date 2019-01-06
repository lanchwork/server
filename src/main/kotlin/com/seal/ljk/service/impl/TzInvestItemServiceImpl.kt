package com.seal.ljk.service.impl

import com.github.pagehelper.Page
import com.seal.ljk.base.IdNotFoundException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.dao.TzInvestItemDao
import com.seal.ljk.model.TzInvestItem
import com.seal.ljk.service.ITzInvestItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * <p>
 * 项目管理服务实现类
 * </p>
 *
 * @author kangxj
 * @since 2019-01-02
 */
@Service
class TzInvestItemServiceImpl : ITzInvestItemService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var tzInvestItemDao: TzInvestItemDao

    override fun getTzInvestItem(id: String): TzInvestItem {
        return tzInvestItemDao.get(id) ?: throw IdNotFoundException()
    }

    override fun getAllTzInvestItem(tzInvestItem: TzInvestItem): List<TzInvestItem> {
        return tzInvestItemDao.getAll(tzInvestItem)
    }

    override fun getAllTzInvestItemInfo(): List<TzInvestItem> {
        return tzInvestItemDao.getAllInfo()
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
