package com.seal.ljk.model

import java.math.BigDecimal

class LoanList(
        var settleableAmt: BigDecimal = BigDecimal(0), //可结算金额
        var settledAmt: BigDecimal= BigDecimal(0),  //已结算金额
        var unsettledAmt: BigDecimal= BigDecimal(0),  //未结算金额

        var list:List<Loan> = listOf()
)