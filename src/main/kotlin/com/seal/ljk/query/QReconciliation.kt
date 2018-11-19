package com.seal.ljk.query

data class QReconciliation (
        var partnerId: String = "",
        var currentPage: Int = 1,
        var pageSize: Int = 10
)