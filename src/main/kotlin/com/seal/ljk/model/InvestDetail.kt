package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

class InvestDetail(
                   var investDetailId: String = "",
                   var investId: String = "",

                   var chainTransNo: String= "",
                   var investorWalletAddr: String= "",

                   var investAmt: BigDecimal= BigDecimal(0),

                   var investPeriod: Int=0,
                   var dayRate: BigDecimal= BigDecimal(0),

                   var investDate:Date,
                   var expirreDate:Date,

                   var preRcvPrincipal: BigDecimal= BigDecimal(0),
                   var preIncome: BigDecimal= BigDecimal(0),
                   var preRcvAmt: BigDecimal= BigDecimal(0),

                   var actualRcvDate:Date,
                   var actualRcvPrincipal: BigDecimal= BigDecimal(0),
                   var actualRcvInterest: BigDecimal= BigDecimal(0),

                   var actualRcvAmt: BigDecimal= BigDecimal(0),
                   var partnerId: String = "",
                   var partnerWalletAddr: String = "",

                   var overdueDay:Int=0,
                   var status:Int=0,
                   var remark: String = ""): Base()