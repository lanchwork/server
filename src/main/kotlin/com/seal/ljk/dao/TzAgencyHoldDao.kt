package com.seal.ljk.dao;

import com.github.pagehelper.Page
import com.seal.ljk.model.TzAgencyHold;
import com.seal.ljk.dao.BaseMapper;

/**
 * <p>
 * 代持Mapper 接口
 * </p>
 *
 * @author kangxj
 * @since 2019-01-02
 */
interface TzAgencyHoldDao : BaseMapper<TzAgencyHold> {
    fun queryConditionsTzAgencyHoldByPage(tzAgencyHold: TzAgencyHold): Page<TzAgencyHold>
}
