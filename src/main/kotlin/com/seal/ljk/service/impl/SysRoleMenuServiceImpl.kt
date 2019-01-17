package com.seal.ljk.service.impl

import com.github.pagehelper.Page
import com.seal.ljk.base.IdNotFoundException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.dao.SysRoleMenuDao
import com.seal.ljk.model.SysMenu
import com.seal.ljk.model.SysRoleMenu
import com.seal.ljk.service.ISysMenuService
import com.seal.ljk.service.ISysRoleMenuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * <p>
 * 角色菜单表 服务实现类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-26
 */
@Service
class SysRoleMenuServiceImpl : ISysRoleMenuService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var sysRoleMenuDao: SysRoleMenuDao

    @Autowired
    lateinit var sysMenuService: ISysMenuService

    override fun getSysRoleMenu(id: String): SysRoleMenu {
        return sysRoleMenuDao.get(id) ?: throw IdNotFoundException()
    }

    override fun getAllSysRoleMenu(sysRoleMenu: SysRoleMenu): List<SysRoleMenu> {
//        val user = getSessionUser() ?: throw AuthException()
        return sysRoleMenuDao.getAll(sysRoleMenu)
    }

    override fun getAllSysRoleMenuByPage(sysRoleMenu: SysRoleMenu): Page<SysRoleMenu> {
//        val user = getSessionUser() ?: throw AuthException()
        return sysRoleMenuDao.getAllByPage(sysRoleMenu)
    }

    override fun insertSysRoleMenu(sysRoleMenu: SysRoleMenu) {
        sysRoleMenuDao.insert(sysRoleMenu)
    }

    override fun updateSysRoleMenu(sysRoleMenu: SysRoleMenu) {
        sysRoleMenuDao.update(sysRoleMenu)
    }

    override fun deleteSysRoleMenu(id: String) {
        sysRoleMenuDao.delete(id)
    }

    override fun getAllSysMenuByRoleId(roleId: String): List<SysMenu> {
        val sysMenu = SysMenu(flag = 1)
        sysMenu.isAll = "0"
        val allMenu = sysMenuService.getAllSysMenu(sysMenu)

        val checkedRoles = getAllSysRoleMenu(SysRoleMenu(roleId = roleId))

        val checkedRoleSet = checkedRoles.map {
            it.menuId
        }.toSet()

        allMenu.forEach {
            it.checked = if (checkedRoleSet.contains(it.id)) "1" else "0"
        }

        return sysMenuService.getMenuTreeList(allMenu)
    }

    override fun deleteSysRoleMenuByRoleId(roleId: String) {
        sysRoleMenuDao.deleteByRoleId(roleId)
    }

}
