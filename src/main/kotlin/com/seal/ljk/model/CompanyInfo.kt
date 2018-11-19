package com.seal.ljk.model

import java.math.BigDecimal

data class CompanyInfo (
    var statisticalDate: String = "",
    var financingAmt: BigDecimal = BigDecimal(0),
    var totalFinancingNumber: Int = 0,
    var totalLoanAmt: BigDecimal = BigDecimal(0),
    var loansNumber: Int = 0,
    var overdueAmt: BigDecimal = BigDecimal(0),
    var overdueRate: BigDecimal = BigDecimal(0),
    var badDebtAmt: BigDecimal = BigDecimal(0),
    var badDebtRate: BigDecimal = BigDecimal(0)
)