package com.seal.ljk.model

import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

/**
 * 用户与角色对应关系
 * @author chenjh
 * @since 2018-12-26
 */
data class SysUserRole(

    @PrimaryKey
    var id: String = "",

    /**
     * 合作方id
     */
    var partnerId: String = "",

    /**
     * 用户ID
     */
    var userId: String = "",

    /**
     * 角色ID
     */
    var roleId: String = "",

    /**
     * 角色编码
     */
    var roleCode: String = ""
) : Base(), IVerify {

    override fun verify() {
        this.apply {
            "用户ID 不能为空" using (this.userId.isNotEmpty())
            "角色ID 不能为空" using (this.roleId.isNotEmpty())
        }
    }
}


