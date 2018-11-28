package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

data class InvestSettlement(
        var partnerId: String = "",
        var partnerWalletAddr: String = "",
        var investorWalletAddr: String = "",

        var investNo: String = "",
        var investDate: Date = Date(),
        var applySettleAmt: BigDecimal = BigDecimal(0),

        var settlePrincipal: BigDecimal = BigDecimal(0),
        var investorProfit: BigDecimal = BigDecimal(0),
        var sealProfit: BigDecimal = BigDecimal(0),

        var status: Int = 0,
        var settleTime: Date = Date()

)