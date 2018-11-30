package com.seal.ljk.provider

import com.seal.ljk.query.QLjkOverdue
import org.apache.ibatis.jdbc.SQL

class LjkOverdueProvider {

    private val LJK_OVERDUE = "ljk_overdue"

    fun queryLjkOverdueByConditions(qLjkOverdue: QLjkOverdue): String{
        val sql:SQL = SQL().SELECT("*").FROM(LJK_OVERDUE)

        /*查询条件*/
        val channelMark = qLjkOverdue.channelMark
        if(channelMark.isNotEmpty()){
            sql.WHERE(" channel_mark LIKE concat('%',#{channelMark},'%')")
        }
        val channelFinApplyId = qLjkOverdue.channelFinApplyId
        if(channelFinApplyId.isNotEmpty()){
            sql.WHERE(" channel_fin_apply_id LIKE concat('%',#{channelFinApplyId},'%')")
        }

        val preRepayDateFrom = qLjkOverdue.preRepayDateFrom
        if(preRepayDateFrom.isNotEmpty()){
            sql.WHERE(" Date(pre_repay_date) >= #{preRepayDateFrom}")
        }
        val preRepayDateTo = qLjkOverdue.preRepayDateTo
        if(preRepayDateTo.isNotEmpty()){
            sql.WHERE(" Date(pre_repay_date) <= #{preRepayDateTo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkOverdue.currentPage - 1) * qLjkOverdue.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkOverdue.pageSize.toString()
        return sqlString
    }
}