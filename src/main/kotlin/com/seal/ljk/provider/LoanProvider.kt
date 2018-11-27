package com.seal.ljk.provider

import com.seal.ljk.query.QLoan
import org.apache.ibatis.jdbc.SQL

class LoanProvider {

    private val LOAN = "loan"

    fun getLoanListByInvestNo(qLoan: QLoan): String{
        val sql:SQL = SQL().SELECT("*").FROM(LOAN)

        /*查询条件*/
        val investNo = qLoan.investNo
        if(investNo.isNotEmpty()){
            sql.WHERE(" invest_no LIKE #{investNo}")
            sql.ORDER_BY("status DESC")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLoan.currentPage - 1) * qLoan.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLoan.pageSize.toString()
        return sqlString
    }

    fun queryInvestLoanByConditions(qLoan: QLoan): String{
        val sql:SQL = SQL().SELECT("* from invest_detail i LEFT JOIN loan l on i.invest_no=l.invest_no")

        /*查询条件*/
        val investorWalletAddr = qLoan.investorWalletAddr
        if(investorWalletAddr.isNotEmpty()){
            sql.WHERE(" investor_wallet_addr LIKE #{investorWalletAddr}")
        }
        val partnerId = qLoan.partnerId
        if(partnerId.isNotEmpty()){
            sql.WHERE(" partner_id LIKE #{partnerId}")
        }
        val status = qLoan.status
        if(status>0){
            sql.WHERE(" l.status LIKE #{status}")
        }
        val investNo = qLoan.investNo
        if(investNo.isNotEmpty()){
            sql.WHERE(" i.invest_no LIKE #{investNo}")
        }

        val repayTimeFrom = qLoan.repayTimeFrom
        if(repayTimeFrom.isNotEmpty()){
            sql.WHERE(" Date(repay_time) >= #{repayTimeFrom}")
        }
        val repayTimeTo = qLoan.repayTimeTo
        if(repayTimeTo.isNotEmpty()){
            sql.WHERE(" Date(repay_time) <= #{repayTimeTo}")
        }

        val loanTimeFrom = qLoan.loanTimeFrom
        if(loanTimeFrom.isNotEmpty()){
            sql.WHERE(" Date(loan_time) >= #{loanTimeFrom}")
        }
        val loanTimeTo = qLoan.loanTimeTo
        if(loanTimeTo.isNotEmpty()){
            sql.WHERE(" Date(loan_time) <= #{loanTimeTo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLoan.currentPage - 1) * qLoan.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLoan.pageSize.toString()
        return sqlString
    }

}