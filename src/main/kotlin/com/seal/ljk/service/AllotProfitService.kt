package com.seal.ljk.service

import com.seal.ljk.dao.AllotProfitDao
import com.seal.ljk.model.AllotProfit
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AllotProfitService {

    @Autowired
    lateinit var allotProfitDao: AllotProfitDao

    fun getByPartnerId(partnerId: String): List<AllotProfit>{
        return allotProfitDao.getByPartnerId(partnerId)
    }

    fun create(allotProfit: AllotProfit): Int{
        return allotProfitDao.create(allotProfit)
    }

    fun update(allotProfit: AllotProfit): Int{
        return allotProfitDao.update(allotProfit)
    }

    fun deleteByPartnerId(partnerId: String): Int{
        return allotProfitDao.deleteByPartnerId(partnerId)
    }
}