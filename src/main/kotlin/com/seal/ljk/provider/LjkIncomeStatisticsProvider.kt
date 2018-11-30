package com.seal.ljk.provider

import com.seal.ljk.query.QLjkIncomeStatistics
import org.apache.ibatis.jdbc.SQL

class LjkIncomeStatisticsProvider {

    private val LJK_INCOME_STATISTICS = "ljk_income_statistics"

    fun queryLjkIncomeStatisticsByConditions(qLjkIncomeStatistics: QLjkIncomeStatistics): String{
        val sql:SQL = SQL().SELECT("*").FROM(LJK_INCOME_STATISTICS)

        /*查询条件*/
        val channelAccountId = qLjkIncomeStatistics.channelAccountId
        if(channelAccountId.isNotEmpty()){
            sql.WHERE(" channel_account_id LIKE concat('%',#{channelAccountId},'%')")
        }
        val channelInvestorId = qLjkIncomeStatistics.channelInvestorId
        if(channelInvestorId.isNotEmpty()){
            sql.WHERE(" channel_investor_id LIKE concat('%',#{channelInvestorId},'%')")
        }
        val channelMark = qLjkIncomeStatistics.channelMark
        if(channelMark.isNotEmpty()){
            sql.WHERE(" channel_mark LIKE concat('%',#{channelMark},'%')")
        }

        val statisticDateFrom = qLjkIncomeStatistics.statisticDateFrom
        if(statisticDateFrom.isNotEmpty()){
            sql.WHERE(" Date(statistic_date) >= #{statisticDateFrom}")
        }
        val statisticDateTo = qLjkIncomeStatistics.statisticDateTo
        if(statisticDateTo.isNotEmpty()){
            sql.WHERE(" Date(statistic_date) <= #{statisticDateTo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkIncomeStatistics.currentPage - 1) * qLjkIncomeStatistics.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkIncomeStatistics.pageSize.toString()
        return sqlString
    }
}