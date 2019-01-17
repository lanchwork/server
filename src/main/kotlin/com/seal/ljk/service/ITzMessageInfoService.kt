package com.seal.ljk.service

import com.seal.ljk.model.TzMessageInfo
import com.github.pagehelper.Page

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lanch
 * @since 2019-01-16
 */
interface ITzMessageInfoService{
    fun getTzMessageInfo(id: String): TzMessageInfo?
    fun getAllTzMessageInfo(tzMessageInfo: TzMessageInfo): List<TzMessageInfo>
    fun getAllTzMessageInfoByPage(tzMessageInfo: TzMessageInfo): Page<TzMessageInfo>
    fun insertTzMessageInfo(tzMessageInfo: TzMessageInfo)
    fun updateTzMessageInfo(tzMessageInfo: TzMessageInfo)
    fun deleteTzMessageInfo(id: String)
}
