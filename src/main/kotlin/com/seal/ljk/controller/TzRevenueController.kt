package com.seal.ljk.controller

import com.seal.ljk.service.ITzRevenueService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.common.success
import com.seal.ljk.model.TzRevenue
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 * 总收益 前端控制器
 * </p>
 *
 * @author chenjh
 * @since 2018-12-28
 */
@Api(description = "总收益 功能相关接口")
@RestController
@RequestMapping("/ljk/tz-revenue")
class TzRevenueController{

    @Autowired
    lateinit var tzRevenueService: ITzRevenueService


    @PostMapping("/get")
    @ApiOperation(value = "获取总收益")
    @VerifyToken
    fun getTzRevenue(@RequestParam id: String): ResVal = success(tzRevenueService.getTzRevenue(id))

    @PostMapping("/list")
    @ApiOperation(value = "总收益方列表")
    @VerifyToken
    fun listTzRevenue(@RequestBody tzRevenue: TzRevenue): ResVal = success(tzRevenueService.getAllTzRevenueByPage(tzRevenue).getPageInfo())


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改总收益")
    @VerifyToken
    fun saveTzRevenue(@RequestBody tzRevenue: TzRevenue): ResVal {
        tzRevenue.verify()
        if (tzRevenue.id.isEmpty()) {
            tzRevenueService.insertTzRevenue(tzRevenue)
        } else {
            tzRevenueService.updateTzRevenue(tzRevenue)
        }
        return success(mapOf("id" to tzRevenue.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除总收益")
    @VerifyToken
    fun deleteTzRevenue(@RequestParam id: String): ResVal {
        tzRevenueService.deleteTzRevenue(id)
        return success()
    }

}
