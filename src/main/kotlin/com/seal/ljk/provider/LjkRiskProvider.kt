package com.seal.ljk.provider

import com.seal.ljk.query.QLjkRisk
import org.apache.ibatis.jdbc.SQL


/**
 * @program: si-server
 *
 * @description: 链金控风控基本信息查询条件拼接
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 10:22
 **/
class LjkRiskProvider {

    private val RISK = "ljk_risk"

    fun queryRisk(qLjkRisk: QLjkRisk): String{
        val sql: SQL = SQL().SELECT("*").FROM(RISK)

        val riskCalculatedId = qLjkRisk.riskCalculateId
        if(riskCalculatedId.isNotEmpty()){
            sql.WHERE(" risk_calculate_id = #{riskCalculatedId}")
        }
        val channelMark = qLjkRisk.channelMark
        if(channelMark.isNotEmpty()){
            sql.WHERE("channel_mark = #{channelMark}")
        }
        val channelCustomerId = qLjkRisk.channelCustomerId
        if(channelCustomerId.isNotEmpty()){
            sql.WHERE("channel_customer_id = #{channelCustomerId}")
        }
        val creditRank = qLjkRisk.creditRank
        if(creditRank.isNotEmpty()){
            sql.WHERE("credit_rank = #{creditRank}")
        }
        val calculateDateFrom = qLjkRisk.calculateDateFrom
        if(calculateDateFrom.isNotEmpty()){
            sql.WHERE(" Date(calculate_date) >= #{calculateDateFrom}")
        }
        val calculateDateTo = qLjkRisk.calculateDateTo
        if(calculateDateTo.isNotEmpty()){
            sql.WHERE(" Date(calculate_date) <= #{calculateDateTo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkRisk.currentPage - 1) * qLjkRisk.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkRisk.pageSize.toString()
        return sqlString
    }
}