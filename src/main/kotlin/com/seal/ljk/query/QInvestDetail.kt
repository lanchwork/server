package com.seal.ljk.query

data class QInvestDetail (
        var investorWalletAddr: String = "",
        var partnerId: String = "",
        var investNo: String = "",
        var investPeriodFrom: String = "",
        var investPeriodTo: String = "",
        var status: String = "",
        var investDateFrom: String = "",
        var investDateTo: String = "",
        var currentPage: Int = 1,
        var pageSize: Int = 10
)