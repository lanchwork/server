package com.seal.ljk.model

import java.text.SimpleDateFormat
import java.util.*

open class Base(
    var createDate: String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()),
    var createUser: String = "",
    var updateDate: String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()),
    var updateUser: String = ""
)