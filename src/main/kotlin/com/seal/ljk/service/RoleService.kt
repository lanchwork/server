package com.seal.ljk.service

import com.seal.ljk.dao.RoleDao
import com.seal.ljk.model.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RoleService {

    @Autowired
    lateinit var roleDao: RoleDao

    fun createRole(role: Role){
        return roleDao.createRole(role)
    }

    fun deleteRoleById(roleId: String) {
        return roleDao.deleteRoleById(roleId)
    }

    fun updateRole(role: Role) {
        return roleDao.updateRole(role)
    }

    fun getRoleList(currentPage: Int, pageSize: Int): List<Role> {
        return roleDao.getRoleList(currentPage,pageSize)
    }


}