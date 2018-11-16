package com.seal.ljk.model

import java.math.BigInteger

class Loan(var loanId: String = "",
           var loanerWalletAddr: String = "",

           var totalRepayAmt: BigInteger ,
           var totalLoanAmt: BigInteger,

           var payInterest: String = "",

           var unpayInterest: BigInteger,
           var totalPayAmt: BigInteger,
           var remark: String = ""): Base()