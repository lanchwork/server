package com.seal.ljk.provider

import com.seal.ljk.query.QLjkFinApply
import org.apache.ibatis.jdbc.SQL


/**
 * @program: si-server
 *
 * @description: 链金控融资信息查询条件拼接
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 13:42
 **/
class LjkFinApplyProvider {

    private val FINAPPLY = "ljk_fin_apply"
    private val LOAN = "ljk_loan"
    private val STATUS_CHANGE = "ljk_status_change"

    fun queryFinApplyId(qLjkFinApply: QLjkFinApply): String{
        val sql: SQL = SQL().SELECT("fa.updateTime as update_time, fa.channel_fin_apply_id as fin_apply_id, fa.apply_date as apply_date, " +
                "fa.product_name as product_name, fa.channel_customer_id as channel_customer_id, fa.interest_rate as interest_rate").FROM("$FINAPPLY as fa ")
        sql.JOIN("$LOAN as l on fa.channel_fin_apply_id=l.channel_fin_apply_id ")
        sql.JOIN("$STATUS_CHANGE as sc on fa.channel_fin_apply_id=sc.business_objectId ")

        val channelMark = qLjkFinApply.channelMark
        if(channelMark.isNotEmpty()){
            sql.WHERE("fa.channel_mark=#{channelMark} ")
        }
        val channelFinApplyId = qLjkFinApply.channelFinApplyId
        if(channelFinApplyId.isNotEmpty()){
            sql.WHERE("fa.channel_fin_apply_id=#{channelFinApplyId} ")
        }
        val investId = qLjkFinApply.investId
        if(investId.isNotEmpty()){
            sql.WHERE("l.channel_invest_id=#{investId} ")
        }
        val borrowerId = qLjkFinApply.borrowerId
        if(borrowerId.isNotEmpty()){
            sql.WHERE("fa.channel_customer_id=#{borrowerId} ")
        }
        val finStatus = qLjkFinApply.finStatus
        if(finStatus.isNotEmpty()){
            sql.WHERE("sc.current_state=#{finStatus} ")
        }
        val applyDateFrom = qLjkFinApply.applyDateFrom
        if(applyDateFrom.isNotEmpty()){
            sql.WHERE("Date(fa.apply_date)>=#{applyDateFrom} ")
        }
        val applyDateTo = qLjkFinApply.applyDateTo
        if(applyDateTo.isNotEmpty()){
            sql.WHERE("Date(fa.apply_date)<=#{applyDateTo} ")
        }
        sql.GROUP_BY("fa.channel_fin_apply_id")
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkFinApply.currentPage - 1) * qLjkFinApply.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkFinApply.pageSize.toString()
        return sqlString
    }
}