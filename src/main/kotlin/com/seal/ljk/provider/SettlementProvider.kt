package com.seal.ljk.provider

import com.seal.ljk.query.QLoan
import com.seal.ljk.query.QSettlement
import org.apache.ibatis.jdbc.SQL

class SettlementProvider {

    private val SETTLEMENT = "settlement"

    fun querySettlement(qSettlement: QSettlement): String{
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
}