package com.seal.ljk.model

import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class InvestDetail(var investDetailId: String = "",
                   var investId: String = "",

                   var chainTransNo: String,
                   var investorWalletAddr: String,

                   var investAmt: BigDecimal= BigDecimal(0),

                   var InvestPeriod: Int=0,
                   var dayRate: BigDecimal= BigDecimal(0),

                   var investDate:String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()),
                   var expirreDate:String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()),

                   var preRcvPrincipal: BigDecimal= BigDecimal(0),
                   var preIncome: BigDecimal= BigDecimal(0),
                   var preRcvAmt: BigDecimal= BigDecimal(0),

                   var actualRcvDate:String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()),
                   var actualRcvPrincipal: BigDecimal= BigDecimal(0),
                   var actualRcvInterest: BigDecimal= BigDecimal(0),

                   var actualRcvAmt: BigDecimal= BigDecimal(0),
                   var partnerId: String = "",
                   var partnerWalletAddr: String = "",

                   var overdueDay:Int=0,
                   var status:Int=0,
                   var remark: String = ""): Base()