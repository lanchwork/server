package com.seal.ljk.model


/**
 * @program: si-server
 *
 * @description: 链金控融资信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 13:37
 **/
data class LjkFinApply(
        var finApplyId:String = "",        //融资申请编号
        var channelMark:String = "",        //渠道标识
        var channelFinApplyId:String = "",        //渠道融资申请编号
        var applyDate:String = "",        //申请日期
        var applyAmt:String = "",        //申请金额
        var productName:String = "",        //产品名称
        var channelCustomerId:String = "",        //渠道客户编号
        var borrowerName:String = "",        //借款人名称
        var term:String = "",        //期限
        var termUnit:String = "",        //期限单位
        var purpose:String = "",        //用途
        var interestRate:String = "",        //正常利率
        var serviceFee:String = "",        //手续费
        var safeguardMode:String = "",        //保障方式
        var currency:String = "",        //币种
        var repayWay:String = "",        //还款方式
        var estimatedRepayAmt:String = "",        //预计还款金额
        var estimatedAmt:String = "",        //预计到手金额
        var approvalAmt:String = "",        //审批金额
        var businessStage:String = "",        //业务阶段
        var approvalState:String = "",        //审批状态
        var remark:String = "",        //备注
        var opType:String = "",        //操作类型
        var updateTime: String = "",    //上链时间
        var remark1: String = "",
        var remark2: String = "",
        var remark3: String = "",
        var remark4: String = "",
        var remark5: String = ""
)
