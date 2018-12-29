package com.seal.ljk.controller

import com.seal.ljk.service.ITzAgencyHoldService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.success
import com.seal.ljk.model.TzAgencyHold
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
 * @since 2018-12-29
 */
@Api(description = " 功能相关接口")
@RestController
@RequestMapping("/ljk/tz-agency-hold")
class TzAgencyHoldController{

    @Autowired
    lateinit var tzAgencyHoldService: ITzAgencyHoldService


    @PostMapping("/get")
    @ApiOperation(value = "获取代持")
    @VerifyToken
    fun getTzAgencyHold(@RequestParam id: String): ResVal = success(tzAgencyHoldService.getTzAgencyHold(id))

    @PostMapping("/list")
    @ApiOperation(value = "代持方列表")
    @VerifyToken
    fun listTzAgencyHold(@RequestBody tzAgencyHold: TzAgencyHold): ResVal = success(tzAgencyHoldService.getAllTzAgencyHoldByPage(tzAgencyHold))


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改代持")
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
    @ApiOperation(value = "删除代持")
    @VerifyToken
    fun deleteTzAgencyHold(@RequestParam id: String): ResVal {
        tzAgencyHoldService.deleteTzAgencyHold(id)
        return success()
    }

}
