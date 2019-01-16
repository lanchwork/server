package com.seal.ljk.dao;

import com.github.pagehelper.Page
import com.seal.ljk.model.SysUser;
import com.seal.ljk.dao.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author chenjh
 * @since 2018-12-25
 */
interface SysUserMapper : BaseMapper<SysUser> {
    fun getUser(channelMark: String, userName: String): SysUser?
    fun findRoleNameByUserIdByPage(sysUser:SysUser): Page<SysUser>
}
