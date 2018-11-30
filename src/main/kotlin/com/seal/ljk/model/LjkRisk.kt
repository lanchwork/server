package com.seal.ljk.model


/**
 * @program: si-server
 *
 * @description: 链金控风控基本信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 10:20
 **/
class LjkRisk(
        //风控基本信息
        var riskCalculateId: String = "",   //风险计算Id
        var channelMark: String = "",   //渠道标识
        var channelCustomerId: String = "",    //渠道客户编号
        var customerName: String = "",    //客户名称
        var channelFinApplyId: String = "",    //渠道融资申请编号
        var totalScore: String = "",    //总得分
        var creditRank: String = "",    //信用等级
        var calculateDate: String = "",    //计算日期
        var opType: String = "",    //操作类型
        var remark: String = "",    //备注
        var updateTime: String = "",    //上链时间
        var remark1: String = "",
        var remark2: String = "",
        var remark3: String = "",
        var remark4: String = "",
        var remark5: String = ""
)
