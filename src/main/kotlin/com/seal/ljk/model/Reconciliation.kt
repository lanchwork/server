package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

data class Reconciliation(
    var reconciliationId: String = "",
    var partnerId: String = "",
    var partnerWalletAddr: String = "",
    var statisticsDate: Date,
    var rcvAmt: BigDecimal = BigDecimal.ZERO,
    var loanAmt: BigDecimal = BigDecimal.ZERO,
    var repayAmt: BigDecimal = BigDecimal.ZERO,
    var balance: BigDecimal = BigDecimal.ZERO,
    var totalInterest: BigDecimal = BigDecimal.ZERO,
    var reconciliationResult: String = "",
    var remark: String = ""
) : Base()