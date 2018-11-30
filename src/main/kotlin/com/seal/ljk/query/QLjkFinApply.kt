package com.seal.ljk.query


/**
 * @program: si-server
 *
 * @description: 链金控融资统计信息查询条件
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 13:39
 **/
data class QLjkFinApply(
        var channelMark: String = "",       //渠道标识
        var channelFinApplyId: String = "",        //融资申请编号
        var investId: String = "",        //投资编号
        var borrowerId: String = "",        //借款人编号
        var finStatus: String = "",    //融资状态
        var applyDateFrom: String = "",    //申请时间
        var applyDateTo: String = "",
        var pageSize: Int = 10,
        var currentPage: Int = 1
)
