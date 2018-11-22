package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

data class PartnerProduct(
        var partnerProductId: String = "",    //合作方产品设置ID
        var allotProfitId: String = "",        //分润设置ID
        var productName: String = "",          //产品名称
        var dayRate: BigDecimal = BigDecimal(0),             //日利率（投）
        var openFlag: Int = 0,               //是否开启
        var endDate: Date = Date(),              //截止日期
        var remark: String = ""
) : Base()