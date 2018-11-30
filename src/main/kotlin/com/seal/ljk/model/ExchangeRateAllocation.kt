package com.seal.ljk.model

import java.math.BigDecimal

data class ExchangeRateAllocation(
        var id: String = "",     //Id
        var currency: String = "",              //币种
        var name: String="",                    //名称
        var exchangeRate: BigDecimal = BigDecimal(0),   //汇率
        var show: String="",                    //显示
        var updateTime: String="",              //更新时间
        var remark: String = ""                 //备注
)