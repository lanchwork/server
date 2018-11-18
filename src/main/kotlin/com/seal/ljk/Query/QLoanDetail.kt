package com.seal.ljk.Query

data class QloanDetail(
        var partnerId: String = "",
        var loanId: String = "",
        var investId: String = "",
        var dueDateFrom: String = "",
        var dueDateTo: String = "",
        var currentPage: Int = 1,
        var pageSize: Int = 10
)