package com.seal.ljk.service

import com.seal.ljk.model.GfManageMise
import com.github.pagehelper.Page

/**
 * <p>
 * GF管理员 服务类
 * </p>
 *
 * @author kangxj
 * @since 2019-01-03
 */
interface IGfManageMiseService{
    fun getGfManageMise(id: String): GfManageMise?
    fun getAllGfManageMise(gfManageMise: GfManageMise): List<GfManageMise>
    fun getAllGfManageMiseByPage(gfManageMise: GfManageMise): Page<GfManageMise>
    fun insertGfManageMise(gfManageMise: GfManageMise)
    fun updateGfManageMise(gfManageMise: GfManageMise)
    fun deleteGfManageMise(id: String)
}
