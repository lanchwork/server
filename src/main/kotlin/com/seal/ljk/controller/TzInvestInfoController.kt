package com.seal.ljk.controller

import com.seal.ljk.service.ITzInvestInfoService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.SysDictUtil
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.common.success
import com.seal.ljk.model.TzInvestInfo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 * 投资信息 前端控制器
 * </p>
 *
 * @author lanch
 * @since 2018-12-28
 */
@Api(description = "投资信息 功能相关接口")
@RestController
@RequestMapping("/ljk/tz-invest-info")
class TzInvestInfoController{

    @Autowired
    lateinit var tzInvestInfoService: ITzInvestInfoService


    @PostMapping("/get")
    @ApiOperation(value = "获取投资信息")
    @VerifyToken
    fun getTzInvestInfo(@RequestParam id: String): ResVal = success(tzInvestInfoService.getTzInvestInfo(id))

    @PostMapping("/list")
    @ApiOperation(value = "投资信息方列表")
    @VerifyToken
    fun listTzInvestInfo(@RequestBody tzInvestInfo: TzInvestInfo): ResVal = success(tzInvestInfoService.getAllTzInvestInfoByPage(tzInvestInfo).getPageInfo())


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改投资信息")
    @VerifyToken
    fun saveTzInvestInfo(@RequestBody tzInvestInfo: TzInvestInfo): ResVal {
        tzInvestInfo.verify()
        if (tzInvestInfo.id.isEmpty()) {
            tzInvestInfoService.insertTzInvestInfo(tzInvestInfo)
        } else {
            tzInvestInfoService.updateTzInvestInfo(tzInvestInfo)
        }
        return success(mapOf("id" to tzInvestInfo.id))
    }

    @PostMapping("/dict")
    @ApiOperation(value = "投资信息字典")
    @VerifyToken
    fun dicTzNoticeInfo(): ResVal = success(SysDictUtil.mapOf("investInfoType", "investInfoStatus"))


}
