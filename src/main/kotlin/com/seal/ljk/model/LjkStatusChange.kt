package com.seal.ljk.model

/**
 * 融资状态迁变信息dto
 * */
data class LjkStatusChange(
        //状态迁变Id
        var statusChangeId: String = "",
        var channelMark: String = "",
        // 业务对象
        var businessObject: String = "",
        //业务对象编号
        var businessObjectId: String = "",
        //当前状态
        var currentState: String = "",
        //备注
        var remark: String = "",
        var updateTime: String = "",               //上链时间

        var remark1: String = "",
        var remark2: String = "",
        var remark3: String = "",
        var remark4: String = "",
        var remark5: String = ""
)