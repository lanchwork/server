package com.seal.ljk.query

data class QLjkCollection(
        // 催收编号
        var collectionId:String="",
        // 催收人员
        var collectioner: String = "",
        // 渠道融资申请编号
        var channelFinApplyId: String = "",

        // 催收日期
        var collectionDateFrom: String = "",
        var collectionDateTo: String = "",

        var pageSize: Int = 10,
        var currentPage: Int = 1
)