package com.seal.ljk.provider

import com.seal.ljk.model.RoleMenuList
import java.lang.StringBuilder


class RoleMenuProvider {
    /**
     * sql语句拼接
     */
    fun updateRoleMenu(roleMenuList: RoleMenuList): String {
        var roleId=roleMenuList.roleId
        val sb = StringBuilder()
        sb.append("INSERT INTO role_menu (role_id,menu_id,menu_pid) VALUES")
        roleMenuList.list.forEach {
            sb.append("(")
            sb.append(roleId)
            sb.append(",")
            sb.append(it.code)
            sb.append(",")
            sb.append(it.pcode)
            sb.append(")")
            sb.append(",")
        }
        val toString = sb.substring(0, sb.length - 1).toString()

        return toString
    }

}