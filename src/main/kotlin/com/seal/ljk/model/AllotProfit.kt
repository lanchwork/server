package com.seal.ljk.model

import java.math.BigDecimal
import java.sql.Timestamp


/**
 * @program: si-server
 *
 * @description:
 *
 * @author: tingyx
 *
 * @create: 2018-11-16 11:49
 **/
class AllotProfit (
        var allotProfitId: String = "",
        var partnerId: String = "",
        var partnerProductCycle: Int = 0,
        var partnerProductDayRate: BigDecimal = BigDecimal(0),
        var allotType: Int = 0,
        var partnerScale: BigDecimal = BigDecimal(0),
        var sealScale: BigDecimal = BigDecimal(0),
        var platformWalletAddr: String = "",
        var investorHighestDayRate: BigDecimal = BigDecimal(0),
        var remark: String = ""
): Base()