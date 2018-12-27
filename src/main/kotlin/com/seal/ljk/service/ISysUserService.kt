package com.seal.ljk.service

import com.seal.ljk.model.SysUser
import com.github.pagehelper.Page

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-25
 */
interface ISysUserService : IBaseService {
    fun getSysUser(id: String): SysUser?
    fun getAllSysUser(sysUser: SysUser): List<SysUser>
    fun getAllSysUserByPage(sysUser: SysUser): Page<SysUser>
    fun insertSysUser(sysUser: SysUser)
    fun updateSysUser(sysUser: SysUser)
    fun deleteSysUser(id: String)
    fun getUserToken(user: SysUser): String
    fun verifyUser(token: String?): SysUser
    fun changePass(oldPass: String, newPass: String)
    fun login(channelMark: String, userName: String, password: String): Map<String, Any>
}
