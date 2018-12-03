package com.seal.ljk.model

import java.util.*

data class Menu (
        var id:Int=0,            //主键id
        var menuName:String="",            //菜单名称
        var url:String="",            //URL
        var sort:Int=0,            //排序
        var pcode:String="",            //父级编码 为0表示是父级菜单
        var code:String="",            //子集编码
        var flag:Int=0,            //是否有效
        var icon:Int=0,           //菜单对应的图标
        var createDate: Date = Date(),
        var createUser: String = "",
        var updateDate: Date = Date(),
        var updateUser: String = ""
)