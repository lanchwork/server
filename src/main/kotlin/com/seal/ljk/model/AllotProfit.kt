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
        var sealWalletAddr: String = "",
        var incomeMethod: Int = 0,
        var partnerRatio: BigDecimal = BigDecimal(0),
        var sealRatio: BigDecimal = BigDecimal(0),
        var remark: String = ""
): Base()