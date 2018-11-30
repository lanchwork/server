package com.seal.ljk.query

data class QLjkAccountDetail(

        var AccountSerialNo:String = "",            //账户流水号
        var channelMark:String = "",            //渠道标识
        var channelAccountId:String ="",   //渠道资金账户号
        var transType:String ="",
        var transId:String ="",
        var pageSize: Int = 10,
        var currentPage: Int = 1
)