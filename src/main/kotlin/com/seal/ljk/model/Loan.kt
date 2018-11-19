package com.seal.ljk.model

import java.math.BigDecimal

class Loan(var loanId: String = "",
           var loanerWalletAddr: String = "",
           var totalRepayAmt: BigDecimal = BigDecimal(0),
           var totalLoanAmt: BigDecimal = BigDecimal(0),
           var payInterest: BigDecimal = BigDecimal(0),
           var unpayInterest: BigDecimal = BigDecimal(0),
           var totalPayAmt: BigDecimal = BigDecimal(0),
           var remark: String = ""
): Base()