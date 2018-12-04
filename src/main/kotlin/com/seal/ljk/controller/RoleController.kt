package com.seal.ljk.controller

import com.seal.ljk.base.logger
import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Role
import com.seal.ljk.service.RoleService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

/**
 * 角色管理
 */
@RestController
@RequestMapping("/role")
@Api(description = "角色管理功能相关接口")
class RoleController {

    @Autowired
    lateinit var roleService: RoleService

    /**
     * 角色新增
     */
    @PostMapping("/add")
    @ApiOperation(value = "角色新增")
    fun createRole(@RequestBody role: Role): ResVal{
        try {
            roleService.createRole(role)
        } catch (e: Exception){
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 角色删除
     */
    @PostMapping("/delete")
    @ApiOperation(value = "角色删除")
    fun deleteRoleById(@RequestParam roleId: String): ResVal {
        try {
            roleService.deleteRoleById(roleId)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 角色更新
     */
    @PostMapping("/update")
    @ApiOperation(value = "角色更新")
    fun updateRole(@RequestBody role: Role): ResVal {
        try {
            roleService.updateRole(role)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 查询角色列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "查询角色列表")
    fun getRoleList(@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val resultList: List<Role>
        val currentPageNew = (currentPage - 1) * pageSize
        try {
            resultList = roleService.getRoleList(currentPageNew, pageSize)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

}