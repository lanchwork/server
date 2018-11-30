package com.seal.ljk.query

data class QLjkOverdue(
        // 渠道标识
        var channelMark:String="",
        // 渠道融资申请编号
        var channelFinApplyId: String = "",
        // 应还日期
        var preRepayDateFrom: String = "",
        var preRepayDateTo: String = "",

        var pageSize: Int = 10,
        var currentPage: Int = 1
)