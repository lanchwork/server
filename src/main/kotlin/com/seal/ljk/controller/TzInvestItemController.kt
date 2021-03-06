package com.seal.ljk.controller

import com.seal.ljk.base.SealException
import com.seal.ljk.service.ITzInvestItemService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.WalletUtil
import com.seal.ljk.common.success
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.model.TzInvestItem
import com.seal.ljk.model.TzTokenMeta
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

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
    fun getTzInvestItem(@RequestParam id: String): ResVal {
        val data = tzInvestItemService.getTzInvestItem(id)
        if (data.tokenNo.isNotEmpty()) {
            WalletUtil.getTokenMetaByNos(arrayOf(data.tokenNo))?.apply {
                if (this.isNotEmpty()) {
                    data.issueAmount = this[0].total_shares?.toBigDecimal()
                    data.allowance = this[0].available_shares?.toBigDecimal()
                    data.issuePrice = this[0].issue_price?.divide(BigDecimal(10000.0))
                }
            }
        }
        return success(data)
    }

    @PostMapping("/list")
    @ApiOperation(value = "项目管理列表")
    @VerifyToken
    fun listTzInvestItem(@RequestBody tzInvestItem: TzInvestItem): ResVal {
        val data = tzInvestItemService.getAllTzInvestItemByPage(tzInvestItem)
        val metaMap = mutableMapOf<String, TzTokenMeta>()
        WalletUtil.getTokenMetaByNos(data.map { it.tokenNo }.toTypedArray())?.forEach {
            metaMap[it.id] = it
        }
        if (metaMap.isNotEmpty()) {
            data.forEach {
                val meta = metaMap[it.tokenNo]
                meta?.apply {
                    it.issueAmount = this.total_shares?.toBigDecimal()
                    it.allowance = this.available_shares?.toBigDecimal()
                    it.issuePrice = this.curr_price?.divide(BigDecimal(10000.0))
                }
            }
        }
        return success(data.getPageInfo())
    }

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
