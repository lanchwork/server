package com.seal.ljk.service

import com.seal.ljk.model.TzNoticeInfo
import com.github.pagehelper.Page

/**
 * <p>
 * 公告 服务类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-28
 */
interface ITzNoticeInfoService{
    fun getTzNoticeInfo(id: String): TzNoticeInfo?
    fun getAllTzNoticeInfo(tzNoticeInfo: TzNoticeInfo): List<TzNoticeInfo>
    fun getAllTzNoticeInfoByPage(tzNoticeInfo: TzNoticeInfo): Page<TzNoticeInfo>
    fun insertTzNoticeInfo(tzNoticeInfo: TzNoticeInfo)
    fun updateTzNoticeInfo(tzNoticeInfo: TzNoticeInfo)
    fun deleteTzNoticeInfo(id: String)
}
