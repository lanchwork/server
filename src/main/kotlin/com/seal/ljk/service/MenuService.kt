package com.seal.ljk.service

import com.seal.ljk.dao.MenuDao
import com.seal.ljk.model.Menu
import com.seal.ljk.model.RoleMenuList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuService {

    @Autowired
    lateinit var menuDao: MenuDao

    fun createMenu(menu: Menu){
        return menuDao.createMenu(menu)
    }

    fun deleteMenuById(menuId: String) {
        return menuDao.deleteMenuById(menuId)
    }

    fun updateMenu(menu: Menu) {
        return menuDao.updateMenu(menu)
    }

    fun getMenuList(currentPage: Int, pageSize: Int): List<Menu> {
        return menuDao.getMenuList(currentPage,pageSize)
    }

    fun updateRoleMenu(roleMenuList: RoleMenuList) {
        return menuDao.updateRoleMenu(roleMenuList)
    }

    fun queryRoleMenu(roleId: Int):List<Int> {
        var roleMenuList = menuDao.queryRoleMenu(roleId)
        var list = mutableListOf<Int>()

        roleMenuList.forEach{
            list.add(it.menuId)
        }
        return list
    }


}