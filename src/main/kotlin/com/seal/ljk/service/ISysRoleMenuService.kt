package com.seal.ljk.service

import com.seal.ljk.model.SysRoleMenu
import com.github.pagehelper.Page
import com.seal.ljk.model.SysMenu

/**
 * <p>
 * 角色菜单表 服务类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-26
 */
interface ISysRoleMenuService : IBaseService {
    fun getSysRoleMenu(id: String): SysRoleMenu
    fun getAllSysRoleMenu(sysRoleMenu: SysRoleMenu): List<SysRoleMenu>
    fun getAllSysRoleMenuByPage(sysRoleMenu: SysRoleMenu): Page<SysRoleMenu>
    fun insertSysRoleMenu(sysRoleMenu: SysRoleMenu)
    fun updateSysRoleMenu(sysRoleMenu: SysRoleMenu)
    fun deleteSysRoleMenu(id: String)
    fun getAllSysMenuByRoleId(roleId: String): List<SysMenu>
    fun deleteSysRoleMenuByRoleId(roleId: String)
    fun queryRoleId(id: String): Int
}
