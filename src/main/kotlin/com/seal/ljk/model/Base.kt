package com.seal.ljk.model

import java.util.*

open class Base(
    var createDate: Date? = null,
    var createUser: String? = null,
    var updateDate: Date? = null,
    var updateUser: String? = null,
    var orderByInfo: Array<String>? = null,
    var currentPage: Int? = null,
    var pageSize: Int? = null
)

interface IVerify {
    fun verify()
}
