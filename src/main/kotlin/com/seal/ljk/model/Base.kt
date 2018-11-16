package com.seal.ljk.model

import java.util.*

open class Base(
    var createDate: Date = Date(),
    var createUser: String = "",
    var updateDate: Date = Date(),
    var updateUser: String = ""
)