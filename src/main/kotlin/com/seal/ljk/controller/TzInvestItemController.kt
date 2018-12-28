package com.seal.ljk.controller

import com.seal.ljk.service.ITzInvestItemService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.success
import com.seal.ljk.model.TzInvestItem
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 * 投资项目 前端控制器
 * </p>
 *
 * @author kangxj
 * @since 2018-12-28
 */
@Api(description = "投资项目 功能相关接口")
@RestController
@RequestMapping("/ljk/tz-invest-item")
class TzInvestItemController{

    @Autowired
    lateinit var tzInvestItemService: ITzInvestItemService


    @PostMapping("/get")
    @ApiOperation(value = "获取投资项目")
    @VerifyToken
    fun getTzInvestItem(@RequestParam id: String): ResVal = success(tzInvestItemService.getTzInvestItem(id))

    @PostMapping("/list")
    @ApiOperation(value = "投资项目方列表")
    @VerifyToken
    fun listTzInvestItem(@RequestBody tzInvestItem: TzInvestItem): ResVal = success(tzInvestItemService.getAllTzInvestItemByPage(tzInvestItem))


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改投资项目")
    @VerifyToken
    fun saveTzInvestItem(@RequestBody tzInvestItem: TzInvestItem): ResVal {
        tzInvestItem.verify()
        if (tzInvestItem.id.isEmpty()) {
            tzInvestItemService.insertTzInvestItem(tzInvestItem)
        } else {
            tzInvestItemService.updateTzInvestItem(tzInvestItem)
        }
        return success(mapOf("id" to tzInvestItem.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除投资项目")
    @VerifyToken
    fun deleteTzInvestItem(@RequestParam id: String): ResVal {
        tzInvestItemService.deleteTzInvestItem(id)
        return success()
    }

}
