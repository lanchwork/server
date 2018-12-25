package com.seal.ljk.controller


import com.seal.ljk.common.ResVal
import com.seal.ljk.common.checkParam
import com.seal.ljk.common.getSessionUser
import com.seal.ljk.model.SysPartner
import com.seal.ljk.model.SysUser
import com.seal.ljk.service.ISysPartnerService

import com.seal.ljk.service.ISysUserService
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author chenjh
 * @since 2018-12-25
 */
@RestController
@RequestMapping("/sys/user")
class SysUserController{

    lateinit var sysUserService: ISysUserService
    lateinit var sysPartenerService: ISysPartnerService


    @PostMapping("/get")
    @ApiOperation(value = "获取用户表")
    fun getSysUser(@RequestParam id: String): ResVal = ResVal(0, sysUserService.getSysUser(id))

    @PostMapping("/list")
    @ApiOperation(value = "用户表方列表")
    fun listSysUser(@RequestBody sysUser: SysUser): ResVal = ResVal(0, sysUserService.getAllSysUser(sysUser))


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改用户表")
    fun saveSysUser(@RequestBody sysUser: SysUser): ResVal {
        sysUser.verify()
        if (sysUser.id.isEmpty()) {
            sysUserService.insertSysUser(sysUser)
        } else {
            sysUserService.updateSysUser(sysUser)
        }
        return ResVal(0, mapOf("id" to sysUser.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户表")
    fun deleteSysUser(@RequestParam id: String): ResVal {
        sysUserService.deleteSysUser(id)
        return ResVal(0, "success")
    }

    @PostMapping("/changePass")
    @ApiOperation(value = "用户修改密码")
    fun changePass(@RequestParam oldPass: String,
                   @RequestParam newPass: String): ResVal {
        sysUserService.changePass(oldPass, newPass)
        return ResVal(0, "success")
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    fun login(@RequestParam channelMark: String,
              @RequestParam userName: String,
              @RequestParam password: String): ResVal {
        sysUserService.login(channelMark, userName, password)
        return ResVal(0, "success")
    }

    @PostMapping("/dict")
    @ApiOperation(value = "用户字典")
    fun dicSysUser(@RequestParam id: String): ResVal {
        //todo 返回渠道标识，角色类型，状态字典
        val user = getSessionUser()!!
        val channelMark = mutableListOf<Map<String, String>>()
        if (user.isSeal()) {
            val allSysPartner = sysPartenerService.getAllSysPartner(SysPartner())
            allSysPartner.forEach {
                channelMark.add(
                    mapOf(
                        "key" to it.id,
                        "vaule" to it.partnerName
                    )
                )
            }
        }


        return ResVal(
            0, mapOf(
                "channelMark" to channelMark
            )
        )
    }



}
