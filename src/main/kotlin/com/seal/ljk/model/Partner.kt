package com.seal.ljk.model

import java.util.*

data class Partner (
        var partnerId: String = "",
        var channelMark: String = "",
        var partnerName: String = "",
        var userNo: String = "",
        var walletAddr: String = "",
        var openFlag: Int = 0,
        var remark: String = "",
        var createDate: Date = Date(),
        var createUser: String = "",
        var updateDate: Date = Date(),
        var updateUser: String = ""
)