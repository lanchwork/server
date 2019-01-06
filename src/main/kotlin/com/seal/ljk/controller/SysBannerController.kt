package com.seal.ljk.controller

import com.seal.ljk.service.ISysBannerService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.getOrCreate
import com.seal.ljk.common.success
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.model.SysBanner
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 * banner 前端控制器
 * </p>
 *
 * @author lanch
 * @since 2019-01-03
 */
@Api(description = "banner 功能相关接口")
@RestController
@RequestMapping("/ljk/sys-banner")
class SysBannerController{

    @Autowired
    lateinit var sysBannerService: ISysBannerService


    @PostMapping("/get")
    @ApiOperation(value = "获取banner")
    @VerifyToken
    fun getSysBanner(@RequestParam id: String): ResVal = success(sysBannerService.getSysBanner(id))

    @PostMapping("/list")
    @ApiOperation(value = "banner方列表")
    @VerifyToken
    fun listSysBanner(@RequestBody sysBanner: SysBanner): ResVal = success(sysBannerService.getAllSysBannerByPage(sysBanner).getPageInfo())

    @PostMapping("/listByLang")
    @ApiOperation(value = "banner方列表 根据语言分组")
    @VerifyToken
    fun listByLang(): ResVal {
        val data = sysBannerService.getAllSysBanner(SysBanner())
        val map = data.groupBy { it.lang }
        return success(map)
    }


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改banner")
    @VerifyToken
    fun saveSysBanner(@RequestBody sysBanner: SysBanner): ResVal {
        if (sysBanner.id.isEmpty()) {
            sysBanner.verify()
            sysBannerService.insertSysBanner(sysBanner)
        } else {
            sysBannerService.updateSysBanner(sysBanner)
        }
        return success(mapOf("id" to sysBanner.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除banner")
    @VerifyToken
    fun deleteSysBanner(@RequestParam id: String): ResVal {
        sysBannerService.deleteSysBanner(id)
        return success()
    }

}
