package com.seal.ljk.service

import com.seal.ljk.model.TzRevenue
import com.github.pagehelper.Page

/**
 * <p>
 * 总收益 服务类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-28
 */
interface ITzRevenueService{
    fun getTzRevenue(id: String): TzRevenue
    fun getAllTzRevenue(tzRevenue: TzRevenue): List<TzRevenue>
    fun getAllTzRevenueByPage(tzRevenue: TzRevenue): Page<TzRevenue>
    fun insertTzRevenue(tzRevenue: TzRevenue)
    fun updateTzRevenue(tzRevenue: TzRevenue)
    fun deleteTzRevenue(id: String)
}
