package com.seal.ljk.model

/**
* 投资人收益统计dto
* */
data class LjkIncomeStatistics(
        var incomeStatisticsId:String="",
        var channelMark:String="",                 // 渠道标识
        var statisticDate:String = "",             // 统计日期

        var channelAccountId:String = "",          // 渠道资金账户号
        var channelInvestorId:String = "",         // 渠道投资人编号
        var totalAmt: String = "",                 // 总金额

        var totalIncome: String = "",              // 总收益
        var investNum: String = "",                // 投资次数
        var incomeRate: String = "",               // 收益率

        var overdueRate: String = "",              // 逾期率
        var badDebtRate: String = "",              // 坏账率
        var updateTime: String = "",               //上链时间

        var remark: String = "",                   // 备注
        var remark1: String = "",
        var remark2: String = "",

        var remark3: String = "",
        var remark4: String = "",
        var remark5: String = ""
)