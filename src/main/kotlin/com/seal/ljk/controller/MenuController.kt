package com.seal.ljk.controller

import com.seal.ljk.base.logger
import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Menu
import com.seal.ljk.model.RoleMenu
import com.seal.ljk.model.RoleMenuList
import com.seal.ljk.model.User
import com.seal.ljk.service.MenuService
import com.seal.ljk.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

/**
 * 菜单管理
 */
@RestController
@RequestMapping("/menu")
@Api(description = "菜单管理功能相关接口")
class MenuController {

    @Autowired
    lateinit var menuService: MenuService

    @Autowired
    lateinit var userService:UserService
    /**
     * 菜单新增
     */
    @PostMapping("/add")
    @ApiOperation(value = "菜单新增")
    fun createMenu(@RequestBody menu: Menu): ResVal{
        try {
            menuService.createMenu(menu)
        } catch (e: Exception){
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 菜单删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "菜单删除")
    fun deleteMenuById(@RequestParam menuId: String): ResVal {
        try {
            menuService.deleteMenuById(menuId)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 菜单更新
     */
    @PostMapping("/update")
    @ApiOperation(value = "菜单更新")
    fun updateMenu(@RequestBody menu: Menu): ResVal {
        try {
            menuService.updateMenu(menu)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 查询菜单列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "查询菜单列表")
    fun getMenuList(@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val resultList: List<Menu>
        val currentPageNew = (currentPage - 1) * pageSize
        try {
            resultList = menuService.getMenuList(currentPageNew, pageSize)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    /**
     * 角色菜单权限配置
     */
    @PostMapping("/batchUpdate")
    @ApiOperation(value = "角色菜单权限配置")
    fun updateRoleMenu(@RequestBody roleMenuList: RoleMenuList): ResVal {
        try {
            menuService.updateRoleMenu(roleMenuList)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 角色菜单权限展示列表
     */
    @PostMapping("/queryMenuByRoleId")
    @ApiOperation(value = "角色菜单权限展示列表")
    fun queryRoleMenu(@RequestParam  roleId: Int): ResVal {
        val resultList: List<RoleMenu>
        try {
            resultList=menuService.queryRoleMenu(roleId)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
    /**
     * 根据用户对象的用户Id查询菜单权限
     */
    @PostMapping("/getMenuListByUser")
    @ApiOperation(value = "根据用户对象的用户Id查询菜单权限")
    fun getMenuListByUser(@RequestBody  user: User): ResVal {
        var resultList:HashMap<String, Any>
        try {
            resultList= userService.getMenuListByUser(user) as HashMap<String, Any>
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

}