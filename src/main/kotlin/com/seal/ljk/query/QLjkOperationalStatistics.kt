package com.seal.ljk.query

data class QLjkOperationalStatistics(
        //统计日期
        var statisticDateFrom: String = "",
        var statisticDateTo: String = "",
        //渠道标识
        var channelMark:String="",

        var pageSize: Int = 10,
        var currentPage: Int = 1
)