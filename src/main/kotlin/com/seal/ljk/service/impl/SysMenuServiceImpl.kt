package com.seal.ljk.service.impl

import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.IdNotFoundException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser
import com.seal.ljk.dao.SysMenuDao
import com.seal.ljk.model.SysMenu
import com.seal.ljk.model.SysUser
import com.seal.ljk.model.SysUserRole
import com.seal.ljk.service.ISysMenuService
import com.seal.ljk.service.ISysUserRoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-25
 */
@Service
class SysMenuServiceImpl : ISysMenuService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var sysMenuDao: SysMenuDao
    @Autowired
    lateinit var sysUserRoleService: ISysUserRoleService

    override fun getSysMenu(id: String): SysMenu {
        return sysMenuDao.get(id) ?: throw IdNotFoundException()
    }

    override fun getAllSysMenu(sysMenu: SysMenu): List<SysMenu> {
        val user = getSessionUser() ?: throw AuthException()
        sysMenu.partnerTypes = if (user.isSeal()) "" else user.partner!!.partnerType
        return sysMenuDao.getAll(sysMenu)
    }

    override fun getAllSysMenuByPage(sysMenu: SysMenu): Page<SysMenu> {
        val user = getSessionUser() ?: throw AuthException()
        sysMenu.partnerTypes = if (user.isSeal()) "" else user.partner!!.partnerType
        return sysMenuDao.getAllByPage(sysMenu)
    }

    override fun insertSysMenu(sysMenu: SysMenu) {
        sysMenuDao.insert(sysMenu)
    }

    override fun updateSysMenu(sysMenu: SysMenu) {
        sysMenuDao.update(sysMenu)
    }


    override fun deleteSysMenu(id: String) {
        sysMenuDao.delete(id)
    }


    override fun getAllSysMenuByUser(user: SysUser): List<SysMenu> {
        val menu = SysMenu()
        if (!user.isSeal()) {
            menu.partnerTypes = user.partner!!.partnerType
        }
        if (!user.isAdmin()) {
            val roleIds = sysUserRoleService.getAllSysUserRole(SysUserRole(userId = user.id)).map { it.roleId }.toTypedArray()
            menu.roleIds = roleIds
        }
        menu.orderByInfo = arrayOf("type", "sort")
        menu.flag = 1
        val all = sysMenuDao.getAll(menu)

        return getMenuTreeList(all)
    }

    override fun getMenuTreeList(all: List<SysMenu>): List<SysMenu> {

        val menuMap = all.groupBy { if (it.parentId.isEmpty()) "0" else it.parentId }
        val result = menuMap["0"] ?: emptyList()

        result.forEach {
            findAllChildMenu(it, menuMap)
        }
        return result
    }

    fun findAllChildMenu(pMenu: SysMenu, menuMap: Map<String, List<SysMenu>>) {
        val list = menuMap[pMenu.id]
        list?.forEach {
            it.parentMenuId = pMenu.menuId
            findAllChildMenu(it, menuMap)
        }
        pMenu.children = list?.toTypedArray()
    }

}
