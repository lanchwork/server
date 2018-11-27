package com.seal.ljk.query

data class QLoan(
        var investorWalletAddr: String = "",
        var partnerId: String = "",
        var status: Int = 0,

        var repayTimeFrom: String = "",
        var repayTimeTo: String = "",

        var loanTimeFrom: String = "",
        var loanTimeTo: String = "",

        var investNo: String = "",
        var currentPage: Int = 1,
        var pageSize: Int = 6
)