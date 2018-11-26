package com.seal.ljk.model

data class RoleMenuList(
        var roleId: Int=0,
        var list:List<Menu> = listOf()
)