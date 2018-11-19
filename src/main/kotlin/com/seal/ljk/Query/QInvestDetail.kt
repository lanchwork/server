package com.seal.ljk.query

data class QInvestDetail (
        var investorWalletAddr: String = "",
        var partnerName: String = "",
        var investId: String = "",
        var investPeriodFrom: String = "",
        var investPeriodTo: String = "",
        var status: String = "",
        var currentPage: Int = 1,
        var pageSize: Int = 10
)