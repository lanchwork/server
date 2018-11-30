package com.seal.ljk.provider

import com.seal.ljk.query.QLjkOperationalStatistics
import org.apache.ibatis.jdbc.SQL

class LjkOperationalStatisticsProvider {

    private val LJK_OPERATIONAL_STATISTICS = "ljk_operational_statistics"

    fun queryLjkOperationalStatisticsByConditions(qLjkOperationalStatistics: QLjkOperationalStatistics): String{
        val sql:SQL = SQL().SELECT("*").FROM(LJK_OPERATIONAL_STATISTICS)

        /*查询条件*/
        val channelMark = qLjkOperationalStatistics.channelMark
        if(channelMark.isNotEmpty()){
            sql.WHERE(" channel_mark LIKE concat('%',#{channelMark},'%')")
        }
        val statisticDateFrom = qLjkOperationalStatistics.statisticDateFrom
        if(statisticDateFrom.isNotEmpty()){
            sql.WHERE(" Date(statistic_date) >= #{statisticDateFrom}")
        }
        val statisticDateTo = qLjkOperationalStatistics.statisticDateTo
        if(statisticDateTo.isNotEmpty()){
            sql.WHERE(" Date(statistic_date) <= #{statisticDateTo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkOperationalStatistics.currentPage - 1) * qLjkOperationalStatistics.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkOperationalStatistics.pageSize.toString()
        return sqlString
    }
}