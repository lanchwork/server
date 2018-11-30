package com.seal.ljk.query


/**
 * @program: si-server
 *
 * @description: 链金控风控基本信息查询条件
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 10:23
 **/
data class QLjkRisk(
        var channelMark: String = "",       //渠道标识
        var channelCustomerId: String = "", //渠道客户编号
        var channelFinApplyId: String = "", //渠道融资申请编号
        var creditRank: String = "",        //信用等级
        var calculateDateFrom: String = "", //计算日期
        var calculateDateTo: String = "",
        var pageSize: Int = 10,
        var currentPage: Int = 1
)
