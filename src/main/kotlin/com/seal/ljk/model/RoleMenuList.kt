package com.seal.ljk.model

data class RoleMenuList(
        var roleId: Int=0,
        var map:Map<String,List<Menu>> = hashMapOf()
)