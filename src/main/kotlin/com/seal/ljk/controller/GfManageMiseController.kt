package com.seal.ljk.controller

import com.seal.ljk.service.IGfManageMiseService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.success
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.model.GfManageMise
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kangxj
 * @since 2019-01-04
 */
@Api(description = " 功能相关接口")
@RestController
@RequestMapping("/ljk/gf-manage-mise")
class GfManageMiseController{

    @Autowired
    lateinit var gfManageMiseService: IGfManageMiseService


    @PostMapping("/get")
    @ApiOperation(value = "获取")
    @VerifyToken
    fun getGfManageMise(@RequestParam id: String): ResVal = success(gfManageMiseService.getGfManageMise(id))

    @PostMapping("/list")
    @ApiOperation(value = "方列表")
    @VerifyToken
    fun listGfManageMise(@RequestBody gfManageMise: GfManageMise): ResVal = success(gfManageMiseService.getAllGfManageMiseByPage(gfManageMise).getPageInfo())


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改")
    @VerifyToken
    fun saveGfManageMise(@RequestBody gfManageMise: GfManageMise): ResVal {
        if (gfManageMise.id.isEmpty()) {
            gfManageMise.verify()
            gfManageMiseService.insertGfManageMise(gfManageMise)
        } else {
            gfManageMiseService.updateGfManageMise(gfManageMise)
        }
        return success(mapOf("id" to gfManageMise.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除")
    @VerifyToken
    fun deleteGfManageMise(@RequestParam id: String): ResVal {
        gfManageMiseService.deleteGfManageMise(id)
        return success()
    }

}
