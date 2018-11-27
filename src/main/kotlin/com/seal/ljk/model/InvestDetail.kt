package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

data class InvestDetail(
        var investDetailId: String = "",
        var userNo: String = "",
        var investNo: String = "",
        var chainTransNo: String = "",
        var investorWalletAddr: String = "",
        var investAmt: BigDecimal = BigDecimal(0),
        var investPeriod: Int = 0,
        var expectDayRate: BigDecimal = BigDecimal(0),
        var investDate: Date = Date(),
        var partnerId: String = "",
        var partnerWalletAddr: String = "",
        var status: Int = 0,
        var remark: String = ""
) : Base()