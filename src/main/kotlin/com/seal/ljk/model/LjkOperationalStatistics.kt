package com.seal.ljk.model

/**
* 平台运营统计dto
* */
data class LjkOperationalStatistics(
        var operationalStatisticsId:String="",
        var channelMark:String="",                 // 渠道标识
        var statisticDate:String = "",             // 统计日期

        var totalApplyAmt:String = "",             // 申请总金额
        var totalLendAmt: String = "",             // 放贷总金额
        var totalIncomeAmt: String = "",           // 收益总金额

        var totalRepayAmt: String = "",            // 还款总金额
        var totalOverdueAmt: String = "",          // 逾期总金额
        var totalBadDebtAmt: String = "",          // 坏账总金额

        var totalInvestAmt: String = "",           // 投资总金额
        var totalApplyNum: String = "",            //  申请总笔数
        var totalLendNum: String = "",             //  放款总笔数

        var totalRepayNum: String = "",            //  还款总笔数
        var totalOverdueNum: String = "",          //  逾期总笔数
        var totalBadDebtNum: String = "",          //  坏账总笔数

        var totalInvestNum: String = "",           //  投资总笔数
        var incomeRate: String = "",               // 收益率
        var ontimeRate: String = "",               // 按时还款率

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