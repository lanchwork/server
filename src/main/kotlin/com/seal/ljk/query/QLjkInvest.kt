package com.seal.ljk.query

data class QLjkInvest(

        var channelMark:String = "",            //渠道标识
        var transId:String = "",            //渠道投资编号
        var investId:String ="" ,   //投资编号
        var productId:String ="" ,
        var investmentDateFrom:String = "",  //投资日期开始
        var investmentDateTo:String = "",  //投资日期结束
        var pageSize: Int = 10,
        var currentPage: Int = 1
)