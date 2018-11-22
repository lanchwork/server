package com.seal.ljk.query

data class QUser(
        var channelMark: String = "",
        var username: String = "",
        var startFlag: String = "",
        var currentPage: Int = 1,
        var pageSize: Int = 10
)