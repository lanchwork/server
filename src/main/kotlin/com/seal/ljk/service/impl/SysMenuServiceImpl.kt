package com.seal.ljk.service.impl

import com.seal.ljk.model.SysMenu
import com.seal.ljk.dao.SysMenuDao
import com.seal.ljk.service.ISysMenuService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getOrCreate
import com.seal.ljk.common.getSessionUser
import com.seal.ljk.model.SysUser

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

    override fun getSysMenu(id: String): SysMenu? {
        return sysMenuDao.get(id)
    }

    override fun getAllSysMenu(sysMenu: SysMenu): Page<SysMenu> {
        val user = getSessionUser() ?: throw AuthException()
        sysMenu.partnerTypes = if (user.isSeal()) "" else user.partner!!.partnerType
        return sysMenuDao.getAll(sysMenu)
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
        //fixme 权限部分未完成，先不做用户权限过滤
        val menu = SysMenu()
        if (!user.isSeal()) {
            menu.partnerTypes = user.partner!!.partnerType
        }
        menu.orderByInfo = arrayOf("type", "sort")
        val all = sysMenuDao.getAll(menu)
        val result = mutableListOf<SysMenu>()

        val menuMap = linkedMapOf<String, MutableList<SysMenu>>()

        all.forEach {
            val pid = if (it.parentId.isEmpty()) "0" else it.parentId
            if (pid == "0") {
                result.add(it)
            } else {
                val list = menuMap.getOrCreate(pid)
                list.add(it)
            }
        }

        result.forEach {
            findAllChildMneu(it, menuMap)
        }
        return result
    }

    fun findAllChildMneu(pMenu: SysMenu, menuMap: Map<String, List<SysMenu>>) {
        val list = menuMap[pMenu.id]
        list?.forEach {
            findAllChildMneu(it, menuMap)
        }
        pMenu.children = list?.toTypedArray()
    }

}
