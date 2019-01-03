package com.seal.ljk.service

import com.seal.ljk.model.SysDictItem
import com.github.pagehelper.Page

/**
 * <p>
 *  数据项列表 服务类
 * </p>
 *
 * @author lanch
 * @since 2019-01-03
 */
interface ISysDictItemService{
    fun getSysDictItem(id: String): SysDictItem?
    fun getAllSysDictItem(sysDictItem: SysDictItem): List<SysDictItem>
    fun getAllSysDictItemByPage(sysDictItem: SysDictItem): Page<SysDictItem>
    fun insertSysDictItem(sysDictItem: SysDictItem)
    fun updateSysDictItem(sysDictItem: SysDictItem)
    fun deleteSysDictItem(id: String)
}
