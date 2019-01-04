package com.seal.ljk.dao;

import com.seal.ljk.model.SysDictType;
import com.seal.ljk.dao.BaseMapper;

/**
 * <p>
 * 数据字典类型 Mapper 接口
 * </p>
 *
 * @author tingyx
 * @since 2019-01-03
 */
interface SysDictTypeDao : BaseMapper<SysDictType>{
    fun getAllSysDict(): List<Map<String,String>>
}
