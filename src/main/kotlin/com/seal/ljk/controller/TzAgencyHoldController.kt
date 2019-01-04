package com.seal.ljk.controller

import com.seal.ljk.service.ITzAgencyHoldService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.SysDictUtil
import com.seal.ljk.common.success
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.model.TzAgencyHold
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 * 代持前端控制器
 * </p>
 *
 * @author kangxj
 * @since 2019-01-02
 */
@Api(description = "代持功能相关接口")
@RestController
@RequestMapping("/ljk/tz-agency-hold")
class TzAgencyHoldController{

    @Autowired
    lateinit var tzAgencyHoldService: ITzAgencyHoldService


    @PostMapping("/get")
    @ApiOperation(value = "代持获取")
    @VerifyToken
    fun getTzAgencyHold(@RequestParam id: String): ResVal = success(tzAgencyHoldService.getTzAgencyHold(id))

    @PostMapping("/list")
    @ApiOperation(value = "代持列表")
    @VerifyToken
    fun listTzAgencyHold(@RequestBody tzAgencyHold: TzAgencyHold): ResVal = success(tzAgencyHoldService.getAllTzAgencyHoldByPage(tzAgencyHold).getPageInfo())


    @PostMapping("/save")
    @ApiOperation(value = "代持新增或修改")
    @VerifyToken
    fun saveTzAgencyHold(@RequestBody tzAgencyHold: TzAgencyHold): ResVal {
        tzAgencyHold.verify()
        if (tzAgencyHold.id.isEmpty()) {
            tzAgencyHoldService.insertTzAgencyHold(tzAgencyHold)
        } else {
            tzAgencyHoldService.updateTzAgencyHold(tzAgencyHold)
        }
        return success(mapOf("id" to tzAgencyHold.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "代持删除")
    @VerifyToken
    fun deleteTzAgencyHold(@RequestParam id: String): ResVal {
        tzAgencyHoldService.deleteTzAgencyHold(id)
        return success()
    }

    @PostMapping("/queryConditions")
    @ApiOperation(value = "代持条件查询")
    @VerifyToken
    fun queryConditionsTzAgencyHold(@RequestBody tzAgencyHold: TzAgencyHold): ResVal = success(tzAgencyHoldService.queryConditionsTzAgencyHoldByPage(tzAgencyHold).getPageInfo())

    @PostMapping("/dict")
    @ApiOperation(value = "代持字典")
    @VerifyToken
    fun dicTzNoticeInfo(): ResVal = success(mapOf("agencyHoldType" to SysDictUtil.sysDict["agencyHoldType"]))
}
