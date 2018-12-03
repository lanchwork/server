package com.seal.ljk.query

data class QDataDetailBusiness(
//        业务对象
        var businessObject: String = "",
//        渠道标识
        var channelMark: String = "",
//        业务编号
        var channelCustomerId: String = "",
//        上链时间
        var updateTime: String = "",
        var currentPage: Int = 1,
        var pageSize: Int = 10
)