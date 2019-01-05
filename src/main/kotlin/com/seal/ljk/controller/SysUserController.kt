package com.seal.ljk.controller


import com.seal.ljk.base.AuthException
import com.seal.ljk.base.IgnoreToken
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.*
import com.seal.ljk.model.SysMenu
import com.seal.ljk.model.SysPartner
import com.seal.ljk.model.SysUser
import com.seal.ljk.service.ISysMenuService
import com.seal.ljk.service.ISysPartnerService

import com.seal.ljk.service.ISysUserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author chenjh
 * @since 2018-12-25
 */
@Api(description = "用户表 功能相关接口")
@RestController
@RequestMapping("/sys/user")
class SysUserController {

    @Autowired
    lateinit var sysUserService: ISysUserService
    @Autowired
    lateinit var sysPartnerService: ISysPartnerService
    @Autowired
    lateinit var sysMenuService: ISysMenuService


    @PostMapping("/get")
    @ApiOperation(value = "获取用户表")
    @VerifyToken
    fun getSysUser(@RequestParam id: String): ResVal = success(sysUserService.getSysUser(id))

    @PostMapping("/list")
    @ApiOperation(value = "用户列表")
    @VerifyToken
    fun listSysUser(@RequestBody sysUser: SysUser): ResVal = success(sysUserService.getAllSysUserByPage(sysUser).getPageInfo())


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改用户表")
    @VerifyToken
    fun saveSysUser(@RequestBody sysUser: SysUser): ResVal {
        sysUser.verify()
        if (sysUser.id.isEmpty()) {
            sysUserService.insertSysUser(sysUser)
        } else {
            sysUserService.updateSysUser(sysUser)
        }
        return success(mapOf("id" to sysUser.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户表")
    @VerifyToken
    fun deleteSysUser(@RequestParam id: String): ResVal {
        sysUserService.deleteSysUser(id)
        return success()
    }

    @PostMapping("/changePass")
    @ApiOperation(value = "用户修改密码")
    @VerifyToken
    fun changePass(@RequestParam oldPass: String,
                   @RequestParam newPass: String): ResVal {
        sysUserService.changePass(oldPass, newPass)
        return success()
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    @IgnoreToken
    fun login(@RequestParam channelMark: String,
              @RequestParam userName: String,
              @RequestParam password: String): ResVal {
        return success(sysUserService.login(channelMark, userName, password))
    }

    @PostMapping("/menuList")
    @ApiOperation(value = "用户权限列表")
    @IgnoreToken
    fun menuList(): ResVal {
        val user = getSessionUser() ?: throw AuthException()
        val menuList = sysMenuService.getAllSysMenuByUser(user)

        return success(sysMenuToMapList(menuList))
    }

    fun sysMenuToMapList(menuList: List<SysMenu>): List<MutableMap<String, Any>> {
        return menuList.map {
            val map = it.toMap(arrayOf("id", "parentId", "menuName", "url"))
            it.children?.apply {
                map["children"] = sysMenuToMapList(this.toList())
            }
            map
        }
    }

    @PostMapping("/dict")
    @ApiOperation(value = "用户字典")
    @VerifyToken
    fun dicSysUser(@RequestParam id: String): ResVal {
        //todo 返回渠道标识，角色类型，状态字典
        val user = getSessionUser()!!
        val channelMark = mutableListOf<Map<String, String>>()
        if (user.isSeal()) {


        }


        return success(mapOf(
                "channelMark" to channelMark
        ))
    }


}
