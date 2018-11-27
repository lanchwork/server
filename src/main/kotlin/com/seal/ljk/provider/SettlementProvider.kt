package com.seal.ljk.provider

import com.seal.ljk.query.QSettlement
import org.apache.ibatis.jdbc.SQL

class SettlementProvider {

    private val SETTLEMENT = "settlement"

    fun getSettlementListByUserNo(qSettlement: QSettlement): String{
        val sql:SQL = SQL().SELECT("*").FROM(SETTLEMENT)

        /*查询条件*/
        val userNo = qSettlement.userNo
        if(userNo.isNotEmpty()){
            sql.WHERE(" user_no LIKE #{userNo}")
            sql.ORDER_BY("apply_time")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qSettlement.currentPage - 1) * qSettlement.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qSettlement.pageSize.toString()
        return sqlString
    }

    fun querySettlementByConditions(qSettlement: QSettlement): String{
        val sql:SQL = SQL().SELECT("* from invest_detail i LEFT JOIN settlement s on i.invest_no=s.invest_no")

        /*查询条件*/
        val partnerId = qSettlement.partnerId
        if(partnerId.isNotEmpty()){
            sql.WHERE(" partner_id LIKE #{partnerId}")
        }
        val investNo = qSettlement.investNo
        if(investNo.isNotEmpty()){
            sql.WHERE(" i.invest_no LIKE #{investNo}")
        }
        val investDateFrom = qSettlement.investDateFrom
        if(investDateFrom.isNotEmpty()){
            sql.WHERE(" Date(invest_date) >= #{investDateFrom}")
        }
        val investDateTo = qSettlement.investDateTo
        if(investDateTo.isNotEmpty()){
            sql.WHERE(" Date(invest_date) <= #{investDateTo}")
        }

        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qSettlement.currentPage - 1) * qSettlement.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qSettlement.pageSize.toString()
        return sqlString
    }
}