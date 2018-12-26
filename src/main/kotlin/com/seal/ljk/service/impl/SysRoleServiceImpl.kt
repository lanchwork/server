package com.seal.ljk.service.impl

import com.seal.ljk.model.SysRole
import com.seal.ljk.dao.SysRoleDao
import com.seal.ljk.service.ISysRoleService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-26
 */
@Service
class SysRoleServiceImpl : ISysRoleService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var sysRoleDao: SysRoleDao

    override fun getSysRole(id: String): SysRole? {
        return sysRoleDao.get(id)
    }

    override fun getAllSysRole(sysRole: SysRole): List<SysRole> {
        val user = getSessionUser() ?: throw AuthException()
        sysRole.channelMark = user.channelMark
        return sysRoleDao.getAll(sysRole)
    }

    override fun getAllSysRoleByPage(sysRole: SysRole): Page<SysRole> {
        val user = getSessionUser() ?: throw AuthException()
        sysRole.channelMark = user.channelMark
        return sysRoleDao.getAllByPage(sysRole)
    }

    override fun insertSysRole(sysRole: SysRole) {
        val user = getSessionUser() ?: throw AuthException()
        sysRole.channelMark = user.channelMark
        sysRoleDao.insert(sysRole)
    }

    override fun updateSysRole(sysRole: SysRole) {
        sysRoleDao.update(sysRole)
    }

    override fun deleteSysRole(id: String) {
        sysRoleDao.delete(id)
    }

}
