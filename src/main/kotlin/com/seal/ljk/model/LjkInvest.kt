package com.seal.ljk.model

/**
 * 投资信息dto
 * */
data class LjkInvest(
        var channelMark:String = "",            //渠道标识
        var channelInvestId:String = "",            //渠道投资编号
        var investId:String ="",   //投资编号
        var channelInvestorId:String = "",            //渠道投资人编号
        var productId:String = "",            //产品编号
        var currency:String = "",            //币种
        var investAmt:String = "",            //投资金额
        var deadline:String = "",            //期限
        var preInterestRate:String = "",            //预计利率
        var prePaymentAmt:String = "",            //预计回款金额
        var preExpireDate:String = "",            //预计到期日期
        var investmentDate:String = "",            //投资时间
        var protectionWay:String = "",            //保障方式
        var businessMode:String = "",            //业务模式
        var investSerialNo:String = "",            //投资流水号
//        var platformSerialNo:String = "",            //平台流水号
        var transId:String = "",            //交易号
        var investState:String = "",            //投资状态
        var payWallet:String = "",            //付款钱包
        var receiptWallet:String = "",            //收款钱包
        var opType:String = "",            //操作类型
        var remark:String = "",            //备注
        var updateTime: String = "",               //上链时间

        var remark1: String = "",
        var remark2: String = "",
        var remark3: String = "",
        var remark4: String = "",
        var remark5: String = ""
)