package com.seal.ljk.model

import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class PlatformStatistics (


        var platformStatisticsId:String = "",
        var statisticsDate:String  = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()),
        var totalTransAmt: BigDecimal = BigDecimal(0),

        var totalTransNum:Int = 0,
        var totalIncomeAmt:BigDecimal= BigDecimal(0),
        var totalBadDebtNum:Int = 0,

        var badDebtRate:BigDecimal= BigDecimal(0),
        var totalOverdueNum:Int = 0,
        var overdueRate:BigDecimal= BigDecimal(0),

        var remark:String = ""

)










