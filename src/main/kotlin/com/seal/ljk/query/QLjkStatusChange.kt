package com.seal.ljk.query

data class QLjkStatusChange(

        var statusChangeId: String = "",
        var businessObject: String = "",
        var businessObjectId: String = "",
        var currentState: String = "",
        var remark: String = "",
        var pageSize: Int = 10,
        var currentPage: Int = 1
)