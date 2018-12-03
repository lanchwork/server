package com.seal.ljk.model

import java.util.*

/**
 * 三级验证
 */
data class DataDetailLocal(

        var transactionId: String = "",
        var channelMark: String = "",
        var channelMarkName: String = "",
        var channelCustomerId: String = "",
        var localHash: String = "",
        var businessObject: String = "",
        var businessObjectName: String = "",
        var fromParty: String = "",
        var updateTime: String = ""
)
