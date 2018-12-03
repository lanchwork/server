package com.seal.ljk.model

data class Protocol(var protocolId: String = "",
               var protocolType: String = "",
               var protocolName: String = "",
               var protocolNo: String = "",
               var protocolContent: String = "",
               var remark: String = ""): Base()