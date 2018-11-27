package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

data class Settlement(
        var settlementId: String = "",
        var userNo: String = "",
        var investNo: String = "",
        var applySettleAmt: BigDecimal = BigDecimal(0),
        var applyTime: Date = Date(),
        var settlePrincipal: BigDecimal = BigDecimal(0),
        var investorProfit: BigDecimal = BigDecimal(0),
        var sealProfit: BigDecimal = BigDecimal(0),
        var status: Int = 0,
        var settleTime: Date = Date(),
        var chainTransNo: String = "",
        var partnerWalletAddr: String = "",
        var investorWalletAddr: String = "",
        var sealWalletAddr: String = "",
        var remark: String = ""
)