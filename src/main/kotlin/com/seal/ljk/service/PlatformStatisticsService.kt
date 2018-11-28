/*
package com.seal.ljk.service

import com.seal.ljk.dao.PlatformStatisticsDao
import com.seal.ljk.model.PlatformStatistics
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*


@Service
class PlatformStatisticsService {

    @Autowired
    lateinit var platformStatisticsDao:PlatformStatisticsDao


    // 查询表中最后一条记录
    fun getPlatformStatisticsLast():PlatformStatistics{
        var platformStatisticsLast = platformStatisticsDao.getPlatformStatisticsLast()
        if (platformStatisticsLast == null){
            platformStatisticsLast = PlatformStatistics()
        }
        return platformStatisticsLast
    }

    /**
     * 添加PlatformStatistics信息,  通过查询投资明细表和结算表
     */
    fun createPlatformStatistics(){

        var platformStatistics = PlatformStatistics()
        //查询投资明细表的信息
        val investDetailList = platformStatisticsDao.getAllInvestDetail()
        //查询结算表的信息
        val SettlementList = platformStatisticsDao.getAllSettlement()

        platformStatistics.platformStatisticsId="No."+UUID.randomUUID().toString().substring(0, 20)
        platformStatistics.totalTransNum = investDetailList.size

        investDetailList.forEach{
            platformStatistics.totalTransAmt += it.investAmt
        }

        var amountDue = BigDecimal(0)
        var amountOverdue = BigDecimal(0)
        //累计收益金额 = 结算表中的投资人分润计算得到
        SettlementList.forEach{
            platformStatistics.totalIncomeAmt += it.investorProfit
        }
        if (amountDue != BigDecimal(0)){
            platformStatistics.overdueRate = amountOverdue / amountDue
        }

        platformStatisticsDao.createPlatformStatistics(platformStatistics)
    }
}*/
