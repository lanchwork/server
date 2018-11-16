package com.seal.ljk.model

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
    var allotProfitId: String? = null,
    var partnerId: String? = null,
    var partnerProductCycle: Int? = null,
    var partnerProductDayRate: Double? = null,
    var allotType: Int? = null,
    var partnerScale: Double? = null,
    var sealScale: Double? = null,
    var platformWalletAddr: String? = null,
    var investorHighestDayRate: Double? = null,
    var remark: String? = null
): Base()