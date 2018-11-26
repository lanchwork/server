package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

/**
 * 合作方委托列表需要数据
 * lanch
 */
data class DelegateData (
        val partnerId:String="",            //合作方id
        val allotProfitId:String="",            //分润id
        val delegateId:String="",            //委托设置id
        val expectDayRate: BigDecimal =BigDecimal(0),            //预期日利率
        val guaranteeWay: Int = 0,           //保障方式
        val incomeMethod: Int = 0,             //收益方式
        val deadline: Date = Date()              //截止时间
)