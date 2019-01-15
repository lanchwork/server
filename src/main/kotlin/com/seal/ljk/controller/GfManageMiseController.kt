package com.seal.ljk.controller

import com.seal.ljk.service.IGfManageMiseService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.*
import com.seal.ljk.model.GfManageMise
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author kangxj
 * @since 2019-01-04
 */
@Api(description = "管理员功能相关接口")
@RestController
@RequestMapping("/ljk/gf-manage-mise")
class GfManageMiseController{

    @Autowired
    lateinit var gfManageMiseService: IGfManageMiseService


    @PostMapping("/get")
    @ApiOperation(value = "管理员获取")
    @VerifyToken
    fun getGfManageMise(@RequestParam id: String): ResVal = success(gfManageMiseService.getGfManageMise(id))

    @PostMapping("/list")
    @ApiOperation(value = "管理员列表")
    @VerifyToken
    fun listGfManageMise(@RequestBody gfManageMise: GfManageMise): ResVal = success(gfManageMiseService.getAllGfManageMiseByPage(gfManageMise).getPageInfo())


    @PostMapping("/save")
    @ApiOperation(value = "管理员新增或修改")
    @VerifyToken
    fun saveGfManageMise(@RequestBody gfManageMise: GfManageMise): ResVal {
        gfManageMise.verify()
        if (gfManageMise.id.isEmpty()) {
            val address = gfManageMise.address
            var count = gfManageMiseService.addressExist(address)
            if(count==1){
                return error("钱包地址已存在")
            }else if(count==0) {
                gfManageMiseService.insertGfManageMise(gfManageMise)
            }
        } else {
            gfManageMiseService.updateGfManageMise(gfManageMise)
        }
        return success(mapOf("id" to gfManageMise.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "管理员删除")
    @VerifyToken
    fun deleteGfManageMise(@RequestParam id: String): ResVal {
        gfManageMiseService.deleteGfManageMise(id)
        return success()
    }

    @PostMapping("/dict")
    @ApiOperation(value = "管理员字典")
    @VerifyToken
    fun dicTzNoticeInfo(): ResVal = success(SysDictUtil.mapOf("gfMagMiseFuncMod"))


}
