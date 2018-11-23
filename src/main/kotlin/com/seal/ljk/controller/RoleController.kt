package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Role
import com.seal.ljk.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

/**
 * 角色管理
 */
@RestController
@RequestMapping("/role")
class RoleController {

    @Autowired
    lateinit var roleService: RoleService

    /**
     * 角色新增
     */
    @RequestMapping("/add")
    fun createRole(@RequestBody role: Role): ResVal{
        try {
            roleService.createRole(role)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 角色删除
     */
    @GetMapping("/delete")
    fun deleteRoleById(@RequestParam roleId: String): ResVal {
        try {
            roleService.deleteRoleById(roleId)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 角色更新
     */
    @RequestMapping("/update")
    fun updateRole(@RequestBody role: Role): ResVal {
        try {
            roleService.updateRole(role)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 查询角色列表
     */
    @GetMapping("/list")
    fun getRoleList(@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val resultList: List<Role>
        val currentPageNew = (currentPage - 1) * pageSize
        try {
            resultList = roleService.getRoleList(currentPageNew, pageSize)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

}