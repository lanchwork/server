package com.seal.ljk.model

import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

/**
 * 角色菜单表
 * @author chenjh
 * @since 2018-12-26
 */
data class SysRoleMenu(

    @PrimaryKey
    var id: String = "",

    /**
     * 角色id
     */
    var roleId: String = "",

    /**
     * 菜单id
     */
    var menuId: String = ""
) : Base(), IVerify {

    var checkedIds: Array<String>? = null

    override fun verify() {
        this.apply {
            "角色id 不能为空" using (this.roleId.isNotEmpty())
            "菜单id 不能为空" using (this.menuId.isNotEmpty())
        }
    }
}


