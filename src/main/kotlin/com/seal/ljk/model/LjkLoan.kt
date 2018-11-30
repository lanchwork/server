package com.seal.ljk.model

/**
 * 放款信息dto
 * */
data class LjkLoan(
        var channelMark:String = "",            //渠道标识
        var channelLoanId:String="",            //渠道放款编号
        var loanId:String = "", //放款编号
        var channelFinApplyId:String="",        //渠道融资申请编号
        var loanDate:String = "",               //放款日期
        var finApplyAmt:String = "",            //融资申请金额
        var actualReleaseAmt:String = "",       //实际发放金额
        var preRepayAmt:String = "",            //预计还款金额
        var currency:String = "",               //币种
        var channelInvestId:String = "",        //渠道投资编号
        var channelInvestorId:String = "",      //渠道投资人编号
        var channelBorrowerId:String = "",      //渠道借款人编号
        var expireDate:String = "",             //到期时间
        var interest:String = "",               //利息
//        var platformSerialNo:String = "",       //平台流水号
        var loanSerialNo:String = "",                //银行的流水号
        var transId:String = "",                //交易号
        var payWallet:String = "",              //付款钱包
        var receiptWallet:String = "",          //收款钱包
        var opType:String = "",                 //操作类型
        var remark:String = "",                  //备注
        var releaseState:String = "",             //放款状态
        var serviceFee:String = "",                //手续费
        var updateTime: String = "",               //上链时间

        var remark1: String = "",
        var remark2: String = "",
        var remark3: String = "",
        var remark4: String = "",
        var remark5: String = ""
)