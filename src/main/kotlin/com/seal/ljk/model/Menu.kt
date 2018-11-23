package com.seal.ljk.model

data class Menu (
        var id:Int=0,            //菜单id
        var menuType:String="",            //一级菜单名称
        var menuName:String=""            //二级菜单名称
)