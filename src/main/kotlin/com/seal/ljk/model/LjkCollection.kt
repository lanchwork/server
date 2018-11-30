package com.seal.ljk.model

/**
 * 催收信息dto
 * */
data class LjkCollection(
        var collectionId:String="",
        var channelMark:String="",                 // 渠道标识
        var channelCollectionId:String = "",       // 渠道催收编号

        var channelOverdueId:String = "",          // 渠道逾期编号
        var channelFinApplyId: String = "",        // 渠道融资申请编号
        var collectionDate: String = "",           // 催收日期

        var collectionWay: String = "",            // 催收方式
        var collectionResult: String = "",         // 催收结果
        var collectioner: String = "",             // 催收人员

        var collectionNum: String = "",            // 累计催收次数
        var updateTime: String = "",               //上链时间
        var remark: String = "",                   // 备注

        var remark1: String = "",
        var remark2: String = "",
        var remark3: String = "",

        var remark4: String = "",
        var remark5: String = ""
)