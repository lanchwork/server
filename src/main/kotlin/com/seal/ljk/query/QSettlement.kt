package com.seal.ljk.query

data class QSettlement(
        var partnerId: String = "",
        var investNo: String = "",
        var investDateFrom: String = "",
        var investDateTo: String = "",

        var userNo: String = "",
        var currentPage: Int = 1,
        var pageSize: Int = 6
)