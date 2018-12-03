package com.seal.ljk.model

import java.util.*

/**
 * 一级验证
 */
data class DataDetail(

        var toChainDate: String = "",
        var channelMark: String = "",
        var channelMarkName: String = "",
        var channelCustomerId: String = "",
        var channelMarkNo: String = "",
        var linkHash: String = "",
        var transactionId: String = "",
        var dataNumber: Int = 0,
        var businessObject: String = "",
        var businessObjectName: String = ""
)
