package com.seal.ljk.controller

import com.seal.ljk.service.ITzNoticeInfoService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.common.success
import com.seal.ljk.model.TzNoticeInfo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 * 公告 前端控制器
 * </p>
 *
 * @author Tingyx
 * @since 2018-12-28
 */
@Api(description = "公告 功能相关接口")
@RestController
@RequestMapping("/ljk/tz-notice-info")
class TzNoticeInfoController{

    @Autowired
    lateinit var tzNoticeInfoService: ITzNoticeInfoService


    @PostMapping("/get")
    @ApiOperation(value = "获取公告")
    @VerifyToken
    fun getTzNoticeInfo(@RequestParam id: String): ResVal = success(tzNoticeInfoService.getTzNoticeInfo(id))

    @PostMapping("/list")
    @ApiOperation(value = "公告列表")
    @VerifyToken
    fun listTzNoticeInfo(@RequestBody tzNoticeInfo: TzNoticeInfo): ResVal = success(tzNoticeInfoService.getAllTzNoticeInfoByPage(tzNoticeInfo).getPageInfo())

    @PostMapping("/save")
    @ApiOperation(value = "新增或修改公告")
    @VerifyToken
    fun saveTzNoticeInfo(@RequestBody tzNoticeInfo: TzNoticeInfo): ResVal {
        if (tzNoticeInfo.id.isEmpty()) {
            tzNoticeInfo.verify()
            tzNoticeInfoService.insertTzNoticeInfo(tzNoticeInfo)
        } else {
            tzNoticeInfoService.updateTzNoticeInfo(tzNoticeInfo)
        }
        return success(mapOf("id" to tzNoticeInfo.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除公告")
    @VerifyToken
    fun deleteTzNoticeInfo(@RequestParam id: String): ResVal {
        tzNoticeInfoService.deleteTzNoticeInfo(id)
        return success()
    }

}
