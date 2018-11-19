package com.seal.ljk.model

import java.math.BigDecimal

class InvestDetailList(
        var totalInvestAmt: BigDecimal = BigDecimal(0), //投资总金额
        var earnedAmt: BigDecimal= BigDecimal(0),  //已收总利息
        var list:List<InvestDetail> = listOf()
)