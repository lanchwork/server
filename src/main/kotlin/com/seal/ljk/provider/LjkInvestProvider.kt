package com.seal.ljk.provider

import com.seal.ljk.query.QLjkInvest
import org.apache.ibatis.jdbc.SQL

class LjkInvestProvider {

    private val LJK_INVEST = "ljk_invest"

    fun queryLjkInvestByConditions(qLjkInvest: QLjkInvest): String{
        val sql:SQL = SQL().SELECT("*").FROM(LJK_INVEST)

        /*查询条件*/
        val channelMark = qLjkInvest.channelMark
        if(channelMark.isNotEmpty()){
            sql.WHERE(" channel_mark LIKE concat('%',#{channelMark},'%')")
        }
        val transId = qLjkInvest.transId
        if(transId.isNotEmpty()){
            sql.WHERE(" trans_id LIKE concat('%',#{transId},'%')")
        }
        val investId = qLjkInvest.investId
        if(investId.isNotEmpty()){
            sql.WHERE(" invest_id LIKE concat('%',#{investId},'%')")
        }

        val investmentDateFrom = qLjkInvest.investmentDateFrom
        if(investmentDateFrom.isNotEmpty()){
            sql.WHERE(" Date(investment_date) >= #{investmentDateFrom}")
        }
        val investmentDateTo = qLjkInvest.investmentDateTo
        if(investmentDateTo.isNotEmpty()){
            sql.WHERE(" Date(investment_date) <= #{investmentDateTo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkInvest.currentPage - 1) * qLjkInvest.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkInvest.pageSize.toString()
        return sqlString
    }
}