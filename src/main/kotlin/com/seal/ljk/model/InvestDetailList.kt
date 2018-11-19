package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

class InvestDetailList (
        var actualRcvPrincipalSum: BigDecimal = BigDecimal(0), //投资总金额 实收本金相加
        var actualRcvInterestSum: BigDecimal= BigDecimal(0),  //已收总利息 实收利息相加
        var list:List<InvestDetail> = listOf()
)