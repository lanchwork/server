package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

class Invest(
        var investId: String = "",
        var investorWalletAddr: String= "",
        var totalPendingAmt: BigDecimal= BigDecimal(0),
        var totalInvestAmt: BigDecimal= BigDecimal(0),
        var earnedAmt: BigDecimal= BigDecimal(0),
        var unearnedAmt: BigDecimal= BigDecimal(0),
        var remark: String = ""
): Base()