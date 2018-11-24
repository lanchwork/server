package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

data class Delegate(
        var delegateId: String = "",    //委托设置ID
        var allotProfitId: String = "",        //分润设置ID
        var entrustDeadline: Int = 0,          //委托期限
        var expectDayRate: BigDecimal = BigDecimal(0),             //预计日利率
        var guaranteeWay: Int = 0,           //保障方式
        var openFlag: Int = 0,               //是否开启
        var deadline: Date = Date(),              //截止时间
        var remark: String = ""
) : Base()