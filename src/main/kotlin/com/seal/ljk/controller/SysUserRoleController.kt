package com.seal.ljk.controller

import com.seal.ljk.service.ISysUserRoleService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.UUIDUtil
import com.seal.ljk.common.getSessionUser
import com.seal.ljk.common.success
import com.seal.ljk.model.SysUser
import com.seal.ljk.model.SysUserRole
import com.seal.ljk.service.ISysUserService
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
@RequestMapping("/sys/userRole")
class SysUserRoleController{

    @Autowired
    lateinit var sysUserRoleService: ISysUserRoleService

    @Autowired
    lateinit var sysUserService: ISysUserService

    @PostMapping("/get")
    @ApiOperation(value = "获取用户与角色对应关系")
    @VerifyToken
    fun getSysUserRole(@RequestParam id: String): ResVal = success(sysUserRoleService.getSysUserRole(id))

    @PostMapping("/list")
    @ApiOperation(value = "用户与角色对应关系列表")
    @VerifyToken
    fun listSysUserRole(@RequestBody sysUserRole: SysUserRole): ResVal = success(sysUserRoleService.getAllSysUserRole(sysUserRole))

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

    @PostMapping("/updateList")
    @ApiOperation(value = "配置用户类型列表")
    @VerifyToken
    fun updateUserTypeList(@RequestBody sysUserRole: SysUserRole):ResVal{
        val userId = sysUserRole.userId
        val roleIdList = sysUserRole.roleIdList
        //根据roleIdList更新对应的用户角色列表 先删后增
        sysUserRoleService.deleteByUserId(userId)
        //拼接sql
        val sb = StringBuilder()
        sb.append("INSERT INTO sys_user_role (id,partner_id,user_id,role_id,role_code,create_date,update_date,create_user,update_user) VALUES")
        val roles = roleIdList.split(",")
        val userSession = getSessionUser()!!
        roles.forEach{
            sb.append("(\'"+UUIDUtil.uuid+"\',")
            sb.append("null,")
            sb.append("\'"+userId+"\'")
            sb.append(",")
            sb.append(it)
            sb.append(",")
            sb.append("null,")
            sb.append("Now()")
            sb.append(",")
            sb.append("Now()")
            sb.append(",")
            sb.append("\'"+userSession.username+"\',")
            sb.append("\'"+userSession.username+"\'")
            sb.append(")")
            sb.append(",")
        }
        val str = sb.substring(0, sb.length - 1).toString()
        sysUserRoleService.insertBatch(str)
        //根据用户id更新对应的userTypeList
        val user=SysUser()
        user.id=userId
        user.userTypeList=roleIdList
        sysUserService.updateSysUser(user)
        return success()
    }

}
