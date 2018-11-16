package com.seal.ljk.model


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
    var loanDetailId: String? = null,
    var partnerId: String? = null,
    var partnerWalletAddr: String? = null,
    var loanId: String? = null,
    var chainTransNo: String? = null,
    var investorWalletAddr: String? = null,
    var investId: String? = null,
    var duePrinpal: String? = null,
    var dueInterest: Double? = null,
    var dueAmt: Double? = null,
    var dueDate: String? = null,
    var actualPayPrincipal: Double? = null,
    var actualPayInterest: Double? = null,
    var actualPayAmt: Double? = null,
    var actualPayDate: String? = null,
    var loanPeriod: String? = null,
    var dayRate: Double? = null,
    var status: Int? = null,
    var overdueDay: Int? = null,
    var investDate: String? = null,
    var remark: String? = null
): Base()