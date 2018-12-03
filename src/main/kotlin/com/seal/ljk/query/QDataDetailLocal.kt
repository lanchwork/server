package com.seal.ljk.query

data class QDataDetailLocal(
        var secondHash: String = "",
        var businessObject: String = "",
        var currentPage: Int = 1,
        var pageSize: Int = 10
)