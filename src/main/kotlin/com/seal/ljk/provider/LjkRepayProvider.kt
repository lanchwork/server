package com.seal.ljk.provider

import com.seal.ljk.query.QLjkRepay
import org.apache.ibatis.jdbc.SQL

class LjkRepayProvider {

    private val LJK_REPAY = "ljk_repay"

    fun queryLjkRepayByConditions(qLjkRepay: QLjkRepay): String{
        val sql:SQL = SQL().SELECT("*").FROM(LJK_REPAY)

        /*查询条件*/
        val receiptWallet = qLjkRepay.receiptWallet
        if(receiptWallet.isNotEmpty()){
            sql.WHERE(" receipt_wallet LIKE concat('%',#{receiptWallet},'%')")
        }
        val repayType = qLjkRepay.repayType
        if(repayType.isNotEmpty()){
            sql.WHERE(" repay_type LIKE concat('%',#{repayType},'%')")
        }
        val payWallet = qLjkRepay.payWallet
        if(payWallet.isNotEmpty()){
            sql.WHERE(" pay_wallet LIKE concat('%',#{payWallet},'%')")
        }

        val repayDateFrom = qLjkRepay.repayDateFrom
        if(repayDateFrom.isNotEmpty()){
            sql.WHERE(" Date(actual_Repay_Date) >= #{repayDateFrom}")
        }
        val repayDateTo = qLjkRepay.repayDateTo
        if(repayDateTo.isNotEmpty()){
            sql.WHERE(" Date(actual_Repay_Date) <= #{repayDateTo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkRepay.currentPage - 1) * qLjkRepay.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkRepay.pageSize.toString()
        return sqlString
    }
}