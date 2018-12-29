package com.seal.ljk.controller

import com.seal.ljk.base.VerifyToken
import com.seal.ljk.service.ISysMenuService
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.common.success
import com.seal.ljk.model.SysMenu
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author chenjh
 * @since 2018-12-25
 */
@Api(description = "菜单 功能相关接口")
@RestController
@RequestMapping("/sys/menu")
class SysMenuController{

    @Autowired
    lateinit var sysMenuService: ISysMenuService


    @PostMapping("/get")
    @ApiOperation(value = "获取菜单表")
    @VerifyToken
    fun getSysMenu(@RequestParam id: String): ResVal = success(sysMenuService.getSysMenu(id))

    @PostMapping("/list")
    @ApiOperation(value = "菜单表方列表")
    @VerifyToken
    fun listSysMenu(@RequestBody sysMenu: SysMenu): ResVal = success(sysMenuService.getAllSysMenuByPage(sysMenu).getPageInfo())


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改菜单表")
    @VerifyToken
    fun saveSysMenu(@RequestBody sysMenu: SysMenu): ResVal {
        sysMenu.verify()
        if (sysMenu.id.isEmpty()) {
            sysMenuService.insertSysMenu(sysMenu)
        } else {
            sysMenuService.updateSysMenu(sysMenu)
        }
        return success(mapOf("id" to sysMenu.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除菜单表")
    @VerifyToken
    fun deleteSysMenu(@RequestParam id: String): ResVal {
        sysMenuService.deleteSysMenu(id)
        return success("success")
    }

}
