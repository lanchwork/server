package com.seal.ljk.service

import com.seal.ljk.dao.PlatformStatisticsDao
import com.seal.ljk.model.PlatformStatistics
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal


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


    fun createPlatformStatistics(){

        var platformStatistics = PlatformStatistics()

        val investDetailList = platformStatisticsDao.getAllInvestDetail()

        platformStatistics.totalTransNum = investDetailList.size

        investDetailList.forEach{
            platformStatistics.totalTransAmt += it.investAmt

            platformStatistics.totalIncomeAmt += it.actualRcvInterest
        }

        val loanDetailList = platformStatisticsDao.getAllLoanDetail()

        var amountDue = BigDecimal(0)

        var amountOverdue = BigDecimal(0)

        loanDetailList.forEach{

            if(it.status == 0){
                amountDue += it.dueAmt -it.actualPayAmt
            }
            if (it.status == 2){
                amountDue += it.dueAmt - it.actualPayAmt
                amountOverdue += it.dueAmt - it.actualPayAmt
            }


        }
        if (amountDue != BigDecimal(0)){
            platformStatistics.overdueRate = amountOverdue / amountDue
        }

        platformStatisticsDao.createPlatformStatistics(platformStatistics)
    }
}