package com.seal.ljk.service.impl

import com.github.pagehelper.Page
import com.seal.ljk.base.IdNotFoundException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.dao.TzRevenueDao
import com.seal.ljk.model.TzRevenue
import com.seal.ljk.service.ITzRevenueService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * <p>
 * 总收益 服务实现类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-28
 */
@Service
class TzRevenueServiceImpl : ITzRevenueService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var tzRevenueDao: TzRevenueDao

    override fun getTzRevenue(id: String): TzRevenue {
        return tzRevenueDao.get(id) ?: throw IdNotFoundException()
    }

    override fun getAllTzRevenue(tzRevenue: TzRevenue): List<TzRevenue> {
        return tzRevenueDao.getAll(tzRevenue)
    }

    override fun getAllTzRevenueByPage(tzRevenue: TzRevenue): Page<TzRevenue> {
        return tzRevenueDao.getAllByPage(tzRevenue)
    }

    override fun insertTzRevenue(tzRevenue: TzRevenue) {
        tzRevenueDao.insert(tzRevenue)
    }

    override fun updateTzRevenue(tzRevenue: TzRevenue) {
        tzRevenueDao.update(tzRevenue)
    }

    override fun deleteTzRevenue(id: String) {
        tzRevenueDao.delete(id)
    }

}
