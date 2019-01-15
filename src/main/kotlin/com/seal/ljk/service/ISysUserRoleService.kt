package com.seal.ljk.service

import com.seal.ljk.model.SysUserRole
import com.github.pagehelper.Page

/**
 * <p>
 * 用户与角色对应关系 服务类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-26
 */
interface ISysUserRoleService{
    fun getSysUserRole(id: String): SysUserRole
    fun getAllSysUserRole(sysUserRole: SysUserRole): List<SysUserRole>
    fun getAllSysUserRoleByPage(sysUserRole: SysUserRole): Page<SysUserRole>
    fun insertSysUserRole(sysUserRole: SysUserRole)
    fun updateSysUserRole(sysUserRole: SysUserRole)
    fun deleteSysUserRole(id: String)
    fun deleteByUserId(userId: String)
    fun insertBatchFast(sysUserRole:SysUserRole)
}
