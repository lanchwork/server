package com.seal.ljk.controller

import com.seal.ljk.service.ITzInvestItemService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.success
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.model.TzInvestItem
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 * 项目管理前端控制器
 * </p>
 *
 * @author kangxj
 * @since 2019-01-02
 */
@Api(description = "项目管理功能相关接口")
@RestController
@RequestMapping("/ljk/tz-invest-item")
class TzInvestItemController{

    @Autowired
    lateinit var tzInvestItemService: ITzInvestItemService


    @PostMapping("/get")
    @ApiOperation(value = "项目管理获取")
    @VerifyToken
    fun getTzInvestItem(@RequestParam id: String): ResVal = success(tzInvestItemService.getTzInvestItem(id))

    @PostMapping("/list")
    @ApiOperation(value = "项目管理列表")
    @VerifyToken
    fun listTzInvestItem(@RequestBody tzInvestItem: TzInvestItem): ResVal = success(tzInvestItemService.getAllTzInvestItemByPage(tzInvestItem).getPageInfo())


    @PostMapping("/save")
    @ApiOperation(value = "项目管理新增或修改")
    @VerifyToken
    fun saveTzInvestItem(@RequestBody tzInvestItem: TzInvestItem): ResVal {
        if (tzInvestItem.id.isEmpty()) {
            tzInvestItem.verify()
            tzInvestItemService.insertTzInvestItem(tzInvestItem)
        } else {
            tzInvestItemService.updateTzInvestItem(tzInvestItem)
        }
        return success(mapOf("id" to tzInvestItem.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "项目管理删除")
    @VerifyToken
    fun deleteTzInvestItem(@RequestParam id: String): ResVal {
        tzInvestItemService.deleteTzInvestItem(id)
        return success()
    }

    @PostMapping("/popList")
    @ApiOperation(value = "项目管理弹窗摘要信息列表")
    @VerifyToken
    fun popList(): ResVal = success(tzInvestItemService.getAllTzInvestItemInfo())

}
