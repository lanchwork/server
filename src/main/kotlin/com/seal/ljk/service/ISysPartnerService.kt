package com.seal.ljk.service

import com.seal.ljk.model.SysPartner
import com.github.pagehelper.Page

/**
 * <p>
 * 合作方表 服务类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-24
 */
interface ISysPartnerService{
    fun getSysPartner(id: String): SysPartner?
    fun getAllSysPartner(sysPartner: SysPartner): Page<SysPartner>
    fun insertSysPartner(sysPartner: SysPartner)
    fun updateSysPartner(sysPartner: SysPartner)
    fun deleteSysPartner(id: String)
    fun getByChannelMark(channelMark: String): SysPartner?
}
