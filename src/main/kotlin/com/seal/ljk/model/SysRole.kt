package com.seal.ljk.model

import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

/**
 * 角色表
 * @author chenjh
 * @since 2018-12-26
 */
data class SysRole(

    /**
     * 主键id
     */
    @PrimaryKey
    var id: String = "",

    /**
     * 角色名称
     */
    var roleName: String = "",

    /**
     * 角色描述
     */
    var roleDesc: String = "",

    /**
     * 合作方表示
     */
    var channelMark: String = "",

    /**
     * 勾选框 1 已选中
     */
    var selected: String = ""
) : Base(), IVerify {

    override fun verify() {
        "角色名称 不能为空" using (roleName.isNotEmpty())
    }
}


