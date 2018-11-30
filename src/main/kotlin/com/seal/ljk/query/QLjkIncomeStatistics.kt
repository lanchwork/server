package com.seal.ljk.query

data class QLjkIncomeStatistics(
        // 渠道资金账户号
        var channelAccountId:String = "",
        // 渠道投资人编号
        var channelInvestorId:String = "",
        // 统计日期
        var statisticDateFrom: String = "",
        var statisticDateTo: String = "",
        // 渠道标识
        var channelMark:String="",

        var pageSize: Int = 10,
        var currentPage: Int = 1
)