package com.seal.ljk.query

data class QLjkLoan(

        var transId: String = "",               //交易号
        var channelMark:String = "",            //渠道标识
        var channelFinApplyId:String="",        //渠道融资申请编号
        var channelInvestorId:String = "",      //渠道投资人编号
        var expireDate:String = "",             //到期时间
        var expireDateFrom : String = "",
        var expireDateTo : String = "",
        var pageSize: Int = 10,
        var currentPage: Int = 1
)