package com.seal.ljk.query

data class QDataDetail(
//        上链日期
        var toChainDate: String = "",
//        渠道标识
        var channelMarkName: String = "",
//        主链交易号
        var transactionId: String = "",
//        主链哈希
        var linkHash: String = "",
        var currentPage: Int = 1,
        var pageSize: Int = 10
)