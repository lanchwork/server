package com.seal.ljk.model

/**
 * 平台资金账户明细dto
 * */
data class LjkAccountDetail(
        var AccountSerialNo:String = "",            //账户流水号
        var channelMark:String = "",            //渠道标识
        var channeAccountSerialNo:String = "",            //渠道账户流水号
        var channelAccountId:String ="",   //渠道资金账户号
//        var platformSerialNo:String = "",            //平台流水号
        var channelInvestId:String = "",         //渠道资金编号（渠道投资编号）
        var transId:String = "",            //交易号
        var currentBalance:String = "",            //当前余额
        var transType:String = "",            //交易类型
        var transAmt:String = "",            //交易金额
        var businessType:String = "",            //业务类型
        var businessId:String = "",            //业务编号
        var transParty:String = "",            //交易方
        var transDate:String = "",            //交易时间
        var transRemark:String = "",            //交易备注
        var remark:String = "",            //备注
        var updateTime: String = "",               //上链时间

        var remark1: String = "",
        var remark2: String = "",
        var remark3: String = "",
        var remark4: String = "",
        var remark5: String = ""
)