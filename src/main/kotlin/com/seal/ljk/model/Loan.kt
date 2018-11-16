package com.seal.ljk.model

import java.math.BigDecimal
import java.math.BigInteger

class Loan(var loanId: String = "",
           var loanerWalletAddr: String = "",

           var totalRepayAmt: BigDecimal,
           var totalLoanAmt: BigDecimal,

           var payInterest: BigDecimal,

           var unpayInterest: BigDecimal,
           var totalPayAmt: BigDecimal,
           var remark: String = ""): Base()