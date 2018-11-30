package com.seal.ljk.model

/**
* 逾期信息dto
* */
data class LjkOverdue(
        var overdueId:String="",
        var channelMark:String="",                 // 渠道标识
        var channelOverdueId:String = "",          // 渠道逾期编号

        var channelFinApplyId: String = "",        // 渠道融资申请编号
        var channelBorrowerId: String = "",        // 渠道借款人编号
        var borrowAmt: String = "",                // 借款金额

        var preRepayDate: String = "",             // 应还日期
        var overdueDays: String = "",              // 逾期天数
        var overdueAmt: String = "",               // 逾期金额

        var normalInterest: String = "",           // 正常利息
        var normalInterestRate: String = "",       // 正常利率
        var overdueInterest: String = "",          // 逾期利息

        var currentOverdueRate: String = "",       // 当前逾期利率
        var overdueCountDate: String = "",         // 逾期计算日期
        var updateTime: String = "",               //上链时间

        var remark: String = "",                   // 备注
        var remark1: String = "",
        var remark2: String = "",

        var remark3: String = "",
        var remark4: String = "",
        var remark5: String = ""
)