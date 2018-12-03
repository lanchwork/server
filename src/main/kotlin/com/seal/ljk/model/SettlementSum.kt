package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

data class SettlementSum(
        var settlementSumId: String = "",
        var userNo: String = "",
        var totalToSettleAmt: BigDecimal = BigDecimal(0),
        var totalSettledAmt: BigDecimal = BigDecimal(0),
        var paidProfit: BigDecimal = BigDecimal(0),
        var toPayProfit: BigDecimal = BigDecimal(0),
        var remark: String = "",
        var createDate: Date = Date(),
        var createUser: String = "",
        var updateDate: Date = Date(),
        var updateUser: String = ""
)