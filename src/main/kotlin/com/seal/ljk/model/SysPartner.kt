package com.seal.ljk.model

import com.seal.ljk.model.Base

/**
 * 合作方表
 * @author chenjh
 * @since 2018-12-24
 */
data class SysPartner(

    /**
     * 主键id
     */
    var id: String = "",

    /**
     * 渠道标识，字典表
     */
    var channelMark: String = "",

    /**
     * 合作方名称
     */
    var partnerName: String = "",

    /**
     * 用户标识
     */
    var userNo: String = "",

    /**
     * 钱包地址
     */
    var walletAddr: String = "",

    /**
     * 是否开启
     */
    var openFlag: Int? = null,

    /**
     * 备注
     */
    var remark: String = "",

    /**
     * 合作类型，0为最高级别（seal）
     */
    var partnerType: Int = 1
) : Base()


