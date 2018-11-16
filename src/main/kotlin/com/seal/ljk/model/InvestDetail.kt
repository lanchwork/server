package com.seal.ljk.model

import java.math.BigDecimal
import java.math.BigInteger
import java.text.SimpleDateFormat
import java.util.*

class InvestDetail(var investDetailId: String = "",
                   var investId: String = "",

                   var chainTransNo: String,
                   var investorWalletAddr: String,

                   var investAmt: BigInteger,

                   var InvestPeriod: Int=0,
                   var dayRate: BigDecimal,

                   var investDate:String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()),
                   var expirreDate:String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()),

                   var preRcvPrincipal: BigInteger,
                   var preIncome: BigInteger,
                   var preRcvAmt: BigInteger,

                   var actualRcvDate:String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()),
                   var actualRcvPrincipal: BigInteger,
                   var actualRcvInterest: BigInteger,

                   var actualRcvAmt: BigInteger,
                   var partnerId: String = "",
                   var partnerWalletAddr: String = "",

                   var overdueDay:Int=0,
                   var status:Int=0,
                   var remark: String = ""): Base()