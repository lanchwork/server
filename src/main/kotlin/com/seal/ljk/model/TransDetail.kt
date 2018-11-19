package com.seal.ljk.model

import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class TransDetail(var transDetailId: String = "",
                  var transDate: Date = Date(),
                  var walletAddr : String = "",
                  var transType : String = "",
                  var platformTransNo : String = "",
                  var chainTransNo : String = "",
                  var transAmt : BigDecimal = BigDecimal(0),
                  var remark: String = ""):Base()
