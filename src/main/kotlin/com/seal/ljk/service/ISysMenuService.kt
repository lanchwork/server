package com.seal.ljk.service

import com.seal.ljk.model.SysMenu
import com.github.pagehelper.Page
import com.seal.ljk.model.SysUser

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-25
 */
interface ISysMenuService{
    fun getSysMenu(id: String): SysMenu?
    fun getAllSysMenu(sysMenu: SysMenu): Page<SysMenu>
    fun insertSysMenu(sysMenu: SysMenu)
    fun updateSysMenu(sysMenu: SysMenu)
    fun deleteSysMenu(id: String)
    fun getAllSysMenuByUser(user: SysUser): List<SysMenu>
}
