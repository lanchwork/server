package com.seal.ljk.model

import com.seal.ljk.base.CreateUser
import com.seal.ljk.base.UpdateUser
import java.util.*

open class Base(
    var createDate: Date? = null,
    @CreateUser
    var createUser: String? = null,
    var updateDate: Date? = null,
    @UpdateUser
    var updateUser: String? = null,
    
    var orderByInfo: Array<String>? = null,
    var currentPage: Int? = null,
    var pageSize: Int? = null
)

interface IVerify {
    fun verify()
}
