package com.seal.ljk.service

import com.seal.ljk.model.TzInvestItem
import com.github.pagehelper.Page

/**
 * <p>
 * 项目管理服务类
 * </p>
 *
 * @author kangxj
 * @since 2019-01-02
 */
interface ITzInvestItemService {
    fun getTzInvestItem(id: String): TzInvestItem?
    fun getAllTzInvestItem(tzInvestItem: TzInvestItem): List<TzInvestItem>
    fun getAllTzInvestItemByPage(tzInvestItem: TzInvestItem): Page<TzInvestItem>
    fun insertTzInvestItem(tzInvestItem: TzInvestItem)
    fun updateTzInvestItem(tzInvestItem: TzInvestItem)
    fun deleteTzInvestItem(id: String)
    fun getAllTzInvestItemInfo(): List<TzInvestItem>
}
