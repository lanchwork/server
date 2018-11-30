package com.seal.ljk.model


/**
 * @program: si-server
 *
 * @description: 链金控风控详细信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 11:46
 **/
data class LjkRiskDetail(

        //风控详细信息
        var riskDetailId: String = "",    //风险详细信息Id
        var riskCalculateId: String = "",   //风险计算Id
        var channelmark: String = "",       //渠道标识
        var channelCustomerId: String = "", //渠道客户编号
        var indexName: String = "",    //指标名称
        var indexValue: String = "",    //指标值
        var indexScore: String = "",    //指标得分
        var creditLine: String = "",    //参考授信额度
        val opType: String = "",        //操作类型
        val remark: String = "",         //备注
        var updateTime: String = "",   //上链时间

        var remark1: String = "",
        var remark2: String = "",
        var remark3: String = "",
        var remark4: String = "",
        var remark5: String = ""

)
