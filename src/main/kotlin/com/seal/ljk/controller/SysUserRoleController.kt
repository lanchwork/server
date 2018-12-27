package com.seal.ljk.controller

import com.seal.ljk.service.ISysUserRoleService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.success
import com.seal.ljk.model.SysUserRole
import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 * 用户与角色对应关系 前端控制器
 * </p>
 *
 * @author chenjh
 * @since 2018-12-26
 */
@Api(description = "用户与角色对应关系 功能相关接口")
@RestController
@RequestMapping("/ljk/sys-user-role")
class SysUserRoleController{

    @Autowired
    lateinit var sysUserRoleService: ISysUserRoleService


    @PostMapping("/get")
    @ApiOperation(value = "获取用户与角色对应关系")
    @VerifyToken
    fun getSysUserRole(@RequestParam id: String): ResVal = success(sysUserRoleService.getSysUserRole(id))

    @PostMapping("/list")
    @ApiOperation(value = "用户与角色对应关系方列表")
    @VerifyToken
    fun listSysUserRole(@RequestBody sysUserRole: SysUserRole): ResVal = success(sysUserRoleService.getAllSysUserRoleByPage(sysUserRole))


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改用户与角色对应关系")
    @VerifyToken
    fun saveSysUserRole(@RequestBody sysUserRole: SysUserRole): ResVal {
        sysUserRole.verify()
        if (sysUserRole.id.isEmpty()) {
            sysUserRoleService.insertSysUserRole(sysUserRole)
        } else {
            sysUserRoleService.updateSysUserRole(sysUserRole)
        }
        return success(mapOf("id" to sysUserRole.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户与角色对应关系")
    @VerifyToken
    fun deleteSysUserRole(@RequestParam id: String): ResVal {
        sysUserRoleService.deleteSysUserRole(id)
        return success()
    }

}
