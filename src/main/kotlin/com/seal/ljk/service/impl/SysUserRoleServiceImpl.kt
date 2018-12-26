package com.seal.ljk.service.impl

import com.seal.ljk.model.SysUserRole
import com.seal.ljk.dao.SysUserRoleDao
import com.seal.ljk.service.ISysUserRoleService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-26
 */
@Service
class SysUserRoleServiceImpl : ISysUserRoleService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var sysUserRoleDao: SysUserRoleDao

    override fun getSysUserRole(id: String): SysUserRole? {
        return sysUserRoleDao.get(id)
    }

    override fun getAllSysUserRole(sysUserRole: SysUserRole): List<SysUserRole> {
//        val user = getSessionUser() ?: throw AuthException()
//        if (user.isSeal()) {
//           sysUserRole.channelMark = ""
//        } else {
//           sysUserRole.channelMark = user.channelMark
//        }
        return sysUserRoleDao.getAll(sysUserRole)
    }

    override fun getAllSysUserRoleByPage(sysUserRole: SysUserRole): Page<SysUserRole> {
//        val user = getSessionUser() ?: throw AuthException()
//        if (user.isSeal()) {
//           sysUserRole.channelMark = ""
//        } else {
//           sysUserRole.channelMark = user.channelMark
//        }
        return sysUserRoleDao.getAllByPage(sysUserRole)
    }

    override fun insertSysUserRole(sysUserRole: SysUserRole) {
        sysUserRoleDao.insert(sysUserRole)
    }

    override fun updateSysUserRole(sysUserRole: SysUserRole) {
        sysUserRoleDao.update(sysUserRole)
    }

    override fun deleteSysUserRole(id: String) {
        sysUserRoleDao.delete(id)
    }

}
