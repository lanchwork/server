package com.seal.ljk.service

import com.seal.ljk.model.TzInvestItem
import com.github.pagehelper.Page

/**
 * <p>
 * 投资项目 服务类
 * </p>
 *
 * @author kangxj
 * @since 2018-12-28
 */
interface ITzInvestItemService{
    fun getTzInvestItem(id: String): TzInvestItem?
    fun getAllTzInvestItem(tzInvestItem: TzInvestItem): List<TzInvestItem>
    fun getAllTzInvestItemByPage(tzInvestItem: TzInvestItem): Page<TzInvestItem>
    fun insertTzInvestItem(tzInvestItem: TzInvestItem)
    fun updateTzInvestItem(tzInvestItem: TzInvestItem)
    fun deleteTzInvestItem(id: String)
}
