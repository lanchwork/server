package com.seal.ljk.model

import java.math.BigDecimal

data class InvestSum(
        var investSumId: String = "",
        var userNo: String = "",
        var totalPendingAmt: BigDecimal = BigDecimal(0),
        var totalInvestAmt: BigDecimal = BigDecimal(0),
        var earnedAmt: BigDecimal = BigDecimal(0),
        var unearnedAmt: BigDecimal = BigDecimal(0),
        var remark: String = ""
) : Base()