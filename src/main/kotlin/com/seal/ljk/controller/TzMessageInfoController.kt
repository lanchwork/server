package com.seal.ljk.controller

import com.seal.ljk.service.ITzMessageInfoService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.success
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.model.TzMessageInfo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lanch
 * @since 2019-01-16
 */
@Api(description = " 功能相关接口")
@RestController
@RequestMapping("/ljk/tz-message-info")
class TzMessageInfoController{

    @Autowired
    lateinit var tzMessageInfoService: ITzMessageInfoService


    @PostMapping("/get")
    @ApiOperation(value = "获取")
    @VerifyToken
    fun getTzMessageInfo(@RequestParam id: String): ResVal = success(tzMessageInfoService.getTzMessageInfo(id))

    @PostMapping("/list")
    @ApiOperation(value = "列表")
    @VerifyToken
    fun listTzMessageInfo(@RequestBody tzMessageInfo: TzMessageInfo): ResVal = success(tzMessageInfoService.getAllTzMessageInfoByPage(tzMessageInfo).getPageInfo())


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改")
    @VerifyToken
    fun saveTzMessageInfo(@RequestBody tzMessageInfo: TzMessageInfo): ResVal {
        if (tzMessageInfo.id.isEmpty()) {
            tzMessageInfo.verify()
            tzMessageInfoService.insertTzMessageInfo(tzMessageInfo)
        } else {
            tzMessageInfoService.updateTzMessageInfo(tzMessageInfo)
        }
        return success(mapOf("id" to tzMessageInfo.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除")
    @VerifyToken
    fun deleteTzMessageInfo(@RequestParam id: String): ResVal {
        tzMessageInfoService.deleteTzMessageInfo(id)
        return success()
    }

}
