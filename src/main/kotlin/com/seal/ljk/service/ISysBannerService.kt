package com.seal.ljk.service

import com.seal.ljk.model.SysBanner
import com.github.pagehelper.Page

/**
 * <p>
 * banner 服务类
 * </p>
 *
 * @author lanch
 * @since 2019-01-03
 */
interface ISysBannerService{
    fun getSysBanner(id: String): SysBanner?
    fun getAllSysBanner(sysBanner: SysBanner): List<SysBanner>
    fun getAllSysBannerByPage(sysBanner: SysBanner): Page<SysBanner>
    fun insertSysBanner(sysBanner: SysBanner)
    fun updateSysBanner(sysBanner: SysBanner)
    fun deleteSysBanner(id: String)
}
