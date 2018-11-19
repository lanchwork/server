package com.seal.ljk.Provider

import com.seal.ljk.Query.QLoanDetail
import org.apache.ibatis.jdbc.SQL

class LoanDetailProvider {

    private val LOAN_DETAIL = "loan_detail"

    fun queryLoanDetail(qLoanDetail: QLoanDetail): String{
        val sql:SQL = SQL().SELECT("*").FROM(LOAN_DETAIL)

        val partnerId = qLoanDetail.partnerId
        if(partnerId.isNotEmpty()){
            sql.WHERE(" partner_id LIKE #{partnerId}")
        }
        val loanId = qLoanDetail.loanId
        if(loanId.isNotEmpty()){
            sql.WHERE(" loan_id LIKE #{loanId}")
        }
        val investId = qLoanDetail.investId
        if(investId.isNotEmpty()){
            sql.WHERE(" invest_id LIKE #{investId}")
        }
        val dueDateFrom = qLoanDetail.dueDateFrom
        if(dueDateFrom.isNotEmpty()){
            sql.WHERE(" Date(due_date) >= #{dueDateFrom}")
        }
        val dueDateTo = qLoanDetail.dueDateTo
        if(dueDateTo.isNotEmpty()){
            sql.WHERE(" Date(due_date) <= #{dueDateTo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLoanDetail.currentPage - 1) * qLoanDetail.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLoanDetail.pageSize.toString()
        return sqlString
    }
}