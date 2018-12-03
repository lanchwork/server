package com.seal.ljk.model

import java.util.*

class Protocol(var protocolId: String = "",
               var protocolType: String = "",
               var protocolName: String = "",
               var protocolNo: String = "",
               var protocolContent: String = "",
               var remark: String = "",
               var createDate: Date = Date(),
               var createUser: String = "",
               var updateDate: Date = Date(),
               var updateUser: String = ""
)