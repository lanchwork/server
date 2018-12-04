package com.seal.ljk.service

import com.seal.ljk.dao.AllotProfitDao
import com.seal.ljk.model.AllotProfit
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AllotProfitService {

    @Autowired
    lateinit var allotProfitDao: AllotProfitDao

    fun getByPartnerId(partnerId: String): List<AllotProfit>{
        return allotProfitDao.getByPartnerId(partnerId)
    }

    fun create(allotProfit: AllotProfit): Int{
        allotProfit.allotProfitId = UUID.randomUUID().toString().substring(0, 20)
        return allotProfitDao.create(allotProfit)
    }

    fun update(allotProfit: AllotProfit): Int{
        return allotProfitDao.update(allotProfit)
    }

    fun deleteByPartnerId(partnerId: String): Int{
        return allotProfitDao.deleteByPartnerId(partnerId)
    }

    fun getAllotProfitList(currentPage : Int, pageSize : Int) : List<AllotProfit> {
        val currentPageNew = (currentPage - 1) * pageSize
        return allotProfitDao.getAllotProfitList(currentPageNew, pageSize)
    }
}