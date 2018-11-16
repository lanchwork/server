package com.seal.ljk.model

import java.math.BigDecimal


/**
 * @program: si-server
 *
 * @description:
 *
 * @author: tingyx
 *
 * @create: 2018-11-16 09:36
 **/
class LoanDetail (
        var loanDetailId: String = "",
        var partnerId: String = "",
        var partnerWalletAddr: String = "",
        var loanId: String = "",
        var chainTransNo: String = "",
        var investorWalletAddr: String = "",
        var investId: String = "",
        var duePrinpal: String = "",
        var dueInterest: BigDecimal = BigDecimal(0),
        var dueAmt: BigDecimal = BigDecimal(0),
        var dueDate: String = "",
        var actualPayPrincipal: BigDecimal = BigDecimal(0),
        var actualPayInterest: BigDecimal = BigDecimal(0),
        var actualPayAmt: BigDecimal = BigDecimal(0),
        var actualPayDate: String = "",
        var loanPeriod: String = "",
        var dayRate: BigDecimal = BigDecimal(0),
        var status: Int = 0,
        var overdueDay: Int = 0,
        var investDate: String = "",
        var remark: String = ""
): Base()