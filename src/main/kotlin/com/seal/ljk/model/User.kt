package com.seal.ljk.model

data class User (
        var id:String="",            //用户名id
        var username:String="",            //用户名
        var password:String = "",           //密码
        var channelMark:String = "",        //渠道标识
        var name:String = "",           //姓名
        var phone:String = "",           //手机号
        var email:String = "",           //邮箱
        var roleType:Int = 0,           //角色类型
        var startFlag:Int = 0           //是否开启   0为是 1为否
)