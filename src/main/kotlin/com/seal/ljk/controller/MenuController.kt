package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Menu
import com.seal.ljk.model.RoleMenu
import com.seal.ljk.model.RoleMenuList
import com.seal.ljk.service.MenuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

/**
 * 菜单管理
 */
@RestController
@RequestMapping("/menu")
class MenuController {

    @Autowired
    lateinit var menuService: MenuService

    /**
     * 菜单新增
     */
    @RequestMapping("/add")
    fun createMenu(@RequestBody menu: Menu): ResVal{
        try {
            menuService.createMenu(menu)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 菜单删除
     */
    @GetMapping("/delete")
    fun deleteMenuById(@RequestParam menuId: String): ResVal {
        try {
            menuService.deleteMenuById(menuId)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 菜单更新
     */
    @RequestMapping("/update")
    fun updateMenu(@RequestBody menu: Menu): ResVal {
        try {
            menuService.updateMenu(menu)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 查询菜单列表
     */
    @GetMapping("/list")
    fun getMenuList(@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val resultList: List<Menu>
        val currentPageNew = (currentPage - 1) * pageSize
        try {
            resultList = menuService.getMenuList(currentPageNew, pageSize)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    /**
     * 角色菜单权限配置
     */
    @RequestMapping("/batchUpdate")
    fun updateRoleMenu(@RequestBody roleMenuList: RoleMenuList): ResVal {
        try {
            menuService.updateRoleMenu(roleMenuList)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 角色菜单权限展示列表
     */
    @GetMapping("/queryMenuByRoleId")
    fun queryRoleMenu(@RequestParam  roleId: Int): ResVal {
        val resultList: List<RoleMenu>
        try {
            resultList=menuService.queryRoleMenu(roleId)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

}