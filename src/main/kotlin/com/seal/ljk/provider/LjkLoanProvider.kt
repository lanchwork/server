package com.seal.ljk.provider

import com.seal.ljk.query.QLjkLoan
import org.apache.ibatis.jdbc.SQL

class LjkLoanProvider {

    private val LJK_LOAN = "ljk_loan"

    fun queryLjkLoanByConditions(qLjkLoan: QLjkLoan): String{
        val sql:SQL = SQL().SELECT("*").FROM(LJK_LOAN)

        /*查询条件*/
        val channelMark = qLjkLoan.channelMark
        if(channelMark.isNotEmpty()){
            sql.WHERE(" channel_mark LIKE concat('%',#{channelMark},'%')")
        }
        val transId = qLjkLoan.transId
        if(transId.isNotEmpty()){
            sql.WHERE(" trans_id LIKE concat('%',#{transId},'%')")
        }
        val channelFinApplyId = qLjkLoan.channelFinApplyId
        if(channelFinApplyId.isNotEmpty()){
            sql.WHERE(" channel_fin_apply_id LIKE concat('%',#{channelFinApplyId},'%')")
        }
        val channelInvestorId = qLjkLoan.channelInvestorId
        if(channelInvestorId.isNotEmpty()){
            sql.WHERE(" channel_investor_id LIKE concat('%',#{channelInvestorId},'%')")
        }

        val expireDateFrom = qLjkLoan.expireDateFrom
        if(expireDateFrom.isNotEmpty()){
            sql.WHERE(" Date(expire_date) >= #{expireDateFrom}")
        }
        val expireDateTo = qLjkLoan.expireDateTo
        if(expireDateTo.isNotEmpty()){
            sql.WHERE(" Date(expire_date) <= #{expireDateTo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkLoan.currentPage - 1) * qLjkLoan.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkLoan.pageSize.toString()
        return sqlString
    }
}