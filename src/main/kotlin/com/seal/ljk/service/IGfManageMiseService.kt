package com.seal.ljk.service

import com.seal.ljk.model.GfManageMise
import com.github.pagehelper.Page

/**
 * <p>
 * 管理员服务类
 * </p>
 *
 * @author kangxj
 * @since 2019-01-04
 */
interface IGfManageMiseService{
    fun getGfManageMise(id: String): GfManageMise
    fun getAllGfManageMise(gfManageMise: GfManageMise): List<GfManageMise>
    fun getAllGfManageMiseByPage(gfManageMise: GfManageMise): Page<GfManageMise>
    fun insertGfManageMise(gfManageMise: GfManageMise)
    fun updateGfManageMise(gfManageMise: GfManageMise)
    fun deleteGfManageMise(id: String)
    fun addressExist(address:String):Int
}
