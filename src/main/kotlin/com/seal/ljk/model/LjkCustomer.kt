package com.seal.ljk.model


/**
 * @program: si-server
 *
 * @description: 链金控客户基本信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 09:44
 **/
data class LjkCustomer(
    //客户基本信息
    var customerId: String = "",    //客户编号
    var channelMark: String = "",        //渠道标识
    var channelCustomerId: String = "",        //渠道客户编号
    var customerType: String = "",        //客户类型
    var customerName: String = "",        //客户名称
    var isCompany: String = "",        //是否公司客户
    var country: String = "",        //国家
    var remark: String = "",        //备注
    var opType: String = "",        //操作类型
    var updateTime: String = "",    //上链时间

    var remark1: String = "",
    var remark2: String = "",
    var remark3: String = "",
    var remark4: String = "",
    var remark5: String = ""
)
