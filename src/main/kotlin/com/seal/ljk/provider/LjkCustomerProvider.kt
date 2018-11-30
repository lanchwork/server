package com.seal.ljk.provider

import com.seal.ljk.query.QLjkCustomer
import org.apache.ibatis.jdbc.SQL


/**
 * @program: si-server
 *
 * @description: 链金控客户基本信息查询条件拼接
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 09:45
 **/
class LjkCustomerProvider {

    private val CUSTOMER = "ljk_customer"

    fun queryCustomer(qLjkCustomer: QLjkCustomer): String{
        val sql: SQL = SQL().SELECT("*").FROM(CUSTOMER)

        val channelMark = qLjkCustomer.channelMark
        if(channelMark.isNotEmpty()){
            sql.WHERE(" channel_mark LIKE #{channelMark}")
        }
        val channelCustomerId = qLjkCustomer.channelCustomerId
        if(channelCustomerId.isNotEmpty()){
            sql.WHERE(" channel_customer_id LIKE #{channelCustomerId}")
        }
        val customerName = qLjkCustomer.customerName
        if(customerName.isNotEmpty()){
            sql.WHERE(" customer_name LIKE #{customerName}")
        }
        val updateTimeFrom = qLjkCustomer.updateTimeFrom
        if(updateTimeFrom.isNotEmpty()){
            sql.WHERE(" Date(updateTime) >= #{updateTimeFrom}")
        }
        val updateTimeTo = qLjkCustomer.updateTimeTo
        if(updateTimeTo.isNotEmpty()){
            sql.WHERE(" Date(updateTime) <= #{updateTimeTo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkCustomer.currentPage - 1) * qLjkCustomer.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkCustomer.pageSize.toString()
        return sqlString
    }

}