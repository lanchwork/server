package com.seal.ljk.model

data class Partner (
    var partnerId: String = "",
    var channelMark: String = "",
    var partnerName: String = "",
    var walletAddr: String = "",
    var openFlag: Int = 0,
    var remark: String = ""
) : Base()