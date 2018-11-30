package com.seal.ljk.provider

import com.seal.ljk.query.QLjkAccountDetail
import org.apache.ibatis.jdbc.SQL

class LjkAccountDetailProvider {

    private val LJK_ACCOUNT_CHANGE = "ljk_account_detail"

    fun queryLjkAccountDetailByConditions(qLjkAccountDetail: QLjkAccountDetail): String{
        val sql:SQL = SQL().SELECT("*").FROM(LJK_ACCOUNT_CHANGE)

        /*查询条件*/
        val AccountSerialNo = qLjkAccountDetail.AccountSerialNo
        if(AccountSerialNo.isNotEmpty()){
            sql.WHERE(" account_serial_no LIKE concat('%',#{AccountSerialNo},'%')")
        }
        val channelMark = qLjkAccountDetail.channelMark
        if(channelMark.isNotEmpty()){
            sql.WHERE(" channel_mark LIKE concat('%',#{channelMark},'%')")
        }
        val channelAccountId = qLjkAccountDetail.channelAccountId
        if(channelAccountId.isNotEmpty()){
            sql.WHERE("channel_account_id LIKE concat('%',#{channelAccountId},'%')")
        }

        val transType = qLjkAccountDetail.transType
        if(transType.isNotEmpty()){
            sql.WHERE("trans_type LIKE concat('%',#{transType},'%')")
        }

        val transId = qLjkAccountDetail.transId
        if(transId.isNotEmpty()){
            sql.WHERE("trans_id LIKE concat('%',#{transId},'%')")
        }

        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkAccountDetail.currentPage - 1) * qLjkAccountDetail.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkAccountDetail.pageSize.toString()
        return sqlString
    }
}