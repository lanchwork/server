package com.seal.ljk.query


/**
 * @program: si-server
 *
 * @description: 链金控客户基本信息查询条件
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 09:45
 **/
data class QLjkCustomer(
        var customerId: String = "",        //客户编号

        var channelMark: String = "",       //渠道标识
        var channelCustomerId: String = "", //渠道客户编号
        var customerName:String = "",       //渠道客户名称
        var updateTimeFrom:String = "",     //上链时间
        var updateTimeTo:String = "",
        var pageSize: Int = 10,
        var currentPage: Int = 1
)
