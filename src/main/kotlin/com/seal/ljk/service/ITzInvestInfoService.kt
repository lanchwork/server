package com.seal.ljk.service

import com.seal.ljk.model.TzInvestInfo
import com.github.pagehelper.Page

/**
 * <p>
 * 投资信息 服务类
 * </p>
 *
 * @author lanch
 * @since 2018-12-28
 */
interface ITzInvestInfoService{
    fun getTzInvestInfo(id: String): TzInvestInfo?
    fun getAllTzInvestInfo(tzInvestInfo: TzInvestInfo): List<TzInvestInfo>
    fun getAllTzInvestInfoByPage(tzInvestInfo: TzInvestInfo): Page<TzInvestInfo>
    fun insertTzInvestInfo(tzInvestInfo: TzInvestInfo)
    fun updateTzInvestInfo(tzInvestInfo: TzInvestInfo)
    fun deleteTzInvestInfo(id: String)
}
