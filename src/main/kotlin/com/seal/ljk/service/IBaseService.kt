package com.seal.ljk.service

import com.github.pagehelper.Page
import com.seal.ljk.model.Base

/**
 * Created by chenjh on 2018/12/24.
 */
interface IBaseService<T : Base> {
    fun get(id: String): T
    fun getAll(data: T): Page<T>
    fun insert(data: T)
    fun update(data: T)
    fun delete(id: String)
}
