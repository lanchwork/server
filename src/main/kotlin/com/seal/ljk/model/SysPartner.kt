package com.seal.ljk.model

import com.seal.ljk.common.using

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
    var walletAddr: String? = null,
    
    /**
     * 是否开启
     */
    var openFlag: Int? = null,
    
    /**
     * 备注
     */
    var remark: String? = null,
    
    /**
     * 合作类型，0为最高级别（seal）
     */
    var partnerType: Int? = null
) : Base(), IVerify {
    
    override fun verify() {
        this.apply {
            "渠道标识 不能为空" using (this.channelMark.isNotEmpty())
            "合作方名称 不能为空" using (this.partnerName.isNotEmpty())
            "是否开启 不能为空" using (this.openFlag != null)
            "合作类型 不能为空" using (this.partnerType != null)
        }
    }
}


