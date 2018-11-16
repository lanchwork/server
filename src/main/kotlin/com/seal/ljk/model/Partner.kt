package com.seal.ljk.model

class Partner (
    var partnerId: String = "",
    var channelMark: String = "",
    var partnerName: String = "",
    var walletAddr: String = "",
    var isOpen: Int = 0,
    var remark: String = ""
) : Base()