package com.seal.ljk.model

data class RoleMenuShow(
        var menuType: String="", //一级菜单名字
        var list:List<RoleMenu> = listOf()
)