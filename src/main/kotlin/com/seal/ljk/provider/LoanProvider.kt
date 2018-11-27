package com.seal.ljk.provider

import com.seal.ljk.query.QLoan
import org.apache.ibatis.jdbc.SQL

class LoanProvider {

    private val LOAN = "loan"

    fun queryLoan(qLoan: QLoan): String{
        val sql:SQL = SQL().SELECT("*").FROM(LOAN)

        /*查询条件*/
        val channelMark = qLoan.investNo
        if(channelMark.isNotEmpty()){
            sql.WHERE(" invest_no LIKE #{investNo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLoan.currentPage - 1) * qLoan.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLoan.pageSize.toString()
        return sqlString
    }
}