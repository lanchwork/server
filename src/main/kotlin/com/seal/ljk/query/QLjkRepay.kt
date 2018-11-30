package com.seal.ljk.query

data class QLjkRepay(

        var channelFinApplyId: String = "",    //融资申请编号,以之为条件查询还款信息 add by: tingyx, 2018-11-29

        var repayType:String = "",          //还款类型
        var payWallet:String = "",          //付款钱包
        var receiptWallet:String = "",          //收款钱包
        var repayDateFrom:String= "",
        var repayDateTo:String = "",
        var pageSize: Int = 10,
        var currentPage: Int = 1

)