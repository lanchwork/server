package com.seal.ljk.dao;

import com.seal.ljk.model.TzAgencyHold;
import com.github.pagehelper.Page

/**
 * <p>
 * 代持 Mapper 接口
 * </p>
 *
 * @author kangxj
 * @since 2018-12-29
 */
interface TzAgencyHoldDao : BaseMapper<TzAgencyHold> {
    fun queryConditionsTzAgencyHoldByPage(tzAgencyHold: TzAgencyHold): Page<TzAgencyHold>
}
