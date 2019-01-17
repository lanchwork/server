package com.seal.ljk.dao;

import com.seal.ljk.model.SysUserRole;
import org.apache.ibatis.annotations.Param

/**
 * <p>
 * 用户与角色对应关系 Mapper 接口
 * </p>
 *
 * @author chenjh
 * @since 2018-12-26
 */
interface SysUserRoleDao : BaseMapper<SysUserRole> {
    fun deleteByUserId(userId: String)
    fun insertFast(@Param("sysUserRoleList") sysUserRoleList: List<SysUserRole>)
    fun findRoleNameByUserId(userRole: SysUserRole): List<SysUserRole>
}
