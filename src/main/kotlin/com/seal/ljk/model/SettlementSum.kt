package com.seal.ljk.model

import java.math.BigDecimal

data class SettlementSum(
        var settlementSumId: String = "",
        var userNo: String = "",
        var totalToSettleAmt: BigDecimal = BigDecimal(0),
        var totalSettledAmt: BigDecimal = BigDecimal(0),
        var paidProfit: BigDecimal = BigDecimal(0),
        var toPayProfit: BigDecimal = BigDecimal(0),
        var remark: String = ""
)