package com.seal.ljk.model

/**
 * 还款信息dto
 * */
data class LjkRepay(
        var channelMark:String = "",           //渠道标识
        var channelRepayId:String = "",         //渠道还款编号
        var repayId:String = "",            //还款编号
        var channelFinApplyId:String = "",          //渠道融资申请编号
        var channelBorrowerId:String = "",          //渠道借款人编号
        var repayType:String = "",          //还款类型
        var currency:String = "",          //币种
        var isPartRepay:String = "",          //是否部分还款
        var borrowAmt:String = "",          //借款金额
        var preRepayDate:String = "",          //应还款时间
        var actualRepayDate:String = "",          //实际还款时间
        var thisRepayPrincipal:String = "",          //本次还款本金
        var thisRepayInterest:String = "",          //本次还款利息
        var thisPenaltyInterest:String = "",          //本次还款罚息
        var otherFeeAmt:String = "",          //其他费用金额
        var otherFeeDesc:String = "",          //其他费用说明
        var normalInterest:String = "",          //正常利息
        var currentOverdueInterest:String = "",          //当前逾期利息
        var repayState:String = "",             //新增还款状态
        var overdueDays:String = "",          //逾期天数
        var repaySerialNo:String = "",          //还款流水号
        var transNo:String = "",          //交易号
        var payWallet:String = "",          //付款钱包
        var receiptWallet:String = "",          //收款钱包
        var opType:String = "",          //操作类型
        var remark:String = "",          //备注
        var updateTime: String = "",               //上链时间

        var remark1: String = "",
        var remark2: String = "",
        var remark3: String = "",
        var remark4: String = "",
        var remark5: String = ""
)