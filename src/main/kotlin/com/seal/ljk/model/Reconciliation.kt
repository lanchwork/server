package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

data class Reconciliation(
    var reconciliationId: String = "",
    var partnerId: String = "",
    var userNo: String = "",
    var statisticsDate: Date,
    var rcvAmt: BigDecimal = BigDecimal.ZERO,
    var loanAmt: BigDecimal = BigDecimal.ZERO,
    var settleAmt: BigDecimal = BigDecimal.ZERO,
    var balance: BigDecimal = BigDecimal.ZERO,
    var investorTotalProfit: BigDecimal = BigDecimal.ZERO,
    var sealTotalProfit: BigDecimal = BigDecimal.ZERO,
    var result: String = "",
    var remark: String = "",
    var createDate: Date = Date(),
    var createUser: String = "",
    var updateDate: Date = Date(),
    var updateUser: String = ""
)