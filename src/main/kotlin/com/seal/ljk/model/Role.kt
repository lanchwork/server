package com.seal.ljk.model

import java.util.*

data class Role (
        var id:Int=0,           //角色id
        var roleName:String="",           //角色名
        var roleDescription:String="",     //角色描述
        var createDate: Date = Date(),
        var createUser: String = "",
        var updateDate: Date = Date(),
        var updateUser: String = ""
)