package com.seal.ljk.provider

import com.seal.ljk.query.QDataDetail
import org.apache.ibatis.jdbc.SQL

class DataDetailProvider {

    private val DATA_DETAIL = "lc_data_detail"

    fun queryLinkDetail(qDataDetail: QDataDetail): String {
        val sql: SQL = SQL().SELECT(" id,to_chain_date,channel_mark,channel_mark_name,channel_customer_id,second_hash,transaction_id,link_hash,data_number,business_object,business_object_name,CONCAT(channel_mark_name,DATE_FORMAT(to_chain_date,'%Y%m%d')) as channel_mark_no").FROM(DATA_DETAIL)

        /*查询条件*/
        val toChainDate = qDataDetail.toChainDate
        if (toChainDate.isNotEmpty()) {
            sql.WHERE(" Date(to_chain_date) >= #{toChainDate}")
        }
        val channelMarkName = qDataDetail.channelMarkName
        if (channelMarkName.isNotEmpty()) {
            sql.WHERE(" channel_mark_name LIKE concat('%',#{channelMarkName},'%') ")
        }
        val transactionId = qDataDetail.transactionId
        if (transactionId.isNotEmpty()) {
            sql.WHERE(" transaction_id LIKE concat('%',#{transactionId},'%') ")
        }

        val linkHash = qDataDetail.linkHash
        if (linkHash.isNotEmpty()) {
            sql.WHERE(" link_hash LIKE concat('%',#{linkHash},'%') ")
        }
        sql.WHERE(" to_chain_date IS NOT NULL ")
        sql.GROUP_BY(" link_hash,channel_mark ")
        sql.ORDER_BY(" to_chain_date DESC")

        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qDataDetail.currentPage - 1) * qDataDetail.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qDataDetail.pageSize.toString()
        return sqlString
    }
}