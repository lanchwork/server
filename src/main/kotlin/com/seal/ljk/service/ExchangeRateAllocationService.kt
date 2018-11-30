package com.seal.ljk.service

import com.seal.ljk.dao.ExchangeRateAllocationDao
import com.seal.ljk.model.ExchangeRateAllocation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

@Service
class ExchangeRateAllocationService {

    @Autowired
    lateinit var ExchangeRateAllocationDao: ExchangeRateAllocationDao

    /**
     * 获取所有ExchangeRate
     */
    fun getAllExchangeRate(): List<ExchangeRateAllocation> {
        return ExchangeRateAllocationDao.getAllNewExchangeRate()
    }

    /**
     * 创建一个汇率记录
     */
    fun createExchangeRate(exchangeRateAllocation:ExchangeRateAllocation):Int{
        exchangeRateAllocation.updateTime=SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
        exchangeRateAllocation.id=UUID.randomUUID().toString().substring(0,31)
        return ExchangeRateAllocationDao.createExchangeRate(exchangeRateAllocation)
    }

    /**
     * 根据currency币种查询所有汇率
     */
    fun getExchangeRateByCurrency(currency: String):List<ExchangeRateAllocation>{
        return ExchangeRateAllocationDao.getExchangeRateByCurrency(currency)
    }

    /**
     * 根据exchange_rate_id修改汇率
     */
    fun  updateExchangeRateById(exchangeRateAllocation:ExchangeRateAllocation){
        val data=ExchangeRateAllocationDao.getExchangeRateById(exchangeRateAllocation.id)
        exchangeRateAllocation.currency=data.currency
        exchangeRateAllocation.name=data.name

        createExchangeRate(exchangeRateAllocation)
    }
}