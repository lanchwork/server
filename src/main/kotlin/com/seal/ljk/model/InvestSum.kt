package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

data class InvestSum(
        var investSumId: String = "",
        var userNo: String = "",
        var totalPendingAmt: BigDecimal = BigDecimal(0),
        var totalInvestAmt: BigDecimal = BigDecimal(0),
        var earnedAmt: BigDecimal = BigDecimal(0),
        var unearnedAmt: BigDecimal = BigDecimal(0),
        var remark: String = "",
        var createDate: Date = Date(),
        var createUser: String = "",
        var updateDate: Date = Date(),
        var updateUser: String = ""
)