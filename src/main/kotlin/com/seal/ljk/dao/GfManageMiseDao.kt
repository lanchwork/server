package com.seal.ljk.dao;

import com.seal.ljk.model.GfManageMise;

/**
 * <p>
 * 管理员Mapper接口
 * </p>
 *
 * @author kangxj
 * @since 2019-01-04
 */
interface GfManageMiseDao : BaseMapper<GfManageMise>{
    fun isExietAddress(address: String):Int
}
