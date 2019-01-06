package com.seal.ljk.service

import com.seal.ljk.model.TzAgencyHold
import com.github.pagehelper.Page

/**
 * <p>
 * 代持服务类
 * </p>
 *
 * @author kangxj
 * @since 2019-01-02
 */
interface ITzAgencyHoldService{
    fun getTzAgencyHold(id: String): TzAgencyHold
    fun getAllTzAgencyHold(tzAgencyHold: TzAgencyHold): List<TzAgencyHold>
    fun getAllTzAgencyHoldByPage(tzAgencyHold: TzAgencyHold): Page<TzAgencyHold>
    fun insertTzAgencyHold(tzAgencyHold: TzAgencyHold)
    fun updateTzAgencyHold(tzAgencyHold: TzAgencyHold)
    fun deleteTzAgencyHold(id: String)
    fun queryConditionsTzAgencyHoldByPage(tzAgencyHold: TzAgencyHold): Page<TzAgencyHold>
}
