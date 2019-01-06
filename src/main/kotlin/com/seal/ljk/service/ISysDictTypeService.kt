package com.seal.ljk.service

import com.seal.ljk.model.SysDictType
import com.github.pagehelper.Page

/**
 * <p>
 * 数据字典类型 服务类
 * </p>
 *
 * @author tingyx
 * @since 2019-01-03
 */
interface ISysDictTypeService{
    fun getSysDictType(id: String): SysDictType
    fun getAllSysDictType(sysDictType: SysDictType): List<SysDictType>
    fun getAllSysDictTypeByPage(sysDictType: SysDictType): Page<SysDictType>
    fun insertSysDictType(sysDictType: SysDictType)
    fun updateSysDictType(sysDictType: SysDictType)
    fun deleteSysDictType(id: String)
    fun getAllSysDict(): List<Map<String,String>>
}
