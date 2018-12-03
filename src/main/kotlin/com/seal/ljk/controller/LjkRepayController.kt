package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkRepay
import com.seal.ljk.query.QLjkRepay
import com.seal.ljk.service.LjkRepayService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 还款信息
 * **/
@RestController
@RequestMapping("/ljkRepay")
@Api(description = "还款信息功能相关接口")
class LjkRepayController {

    @Autowired
    lateinit var ljkRepayService: LjkRepayService

    /**
     * 还款信息条件查询
     * **/
    @ApiOperation(value = "还款信息条件查询")
    @PostMapping("/queryLjkRepay")
    fun queryLjkRepayByConditions(@RequestBody qLjkRepay: QLjkRepay): ResVal {
        val resultList: List<LjkRepay>
        try {
            resultList = ljkRepayService.queryLjkRepayByConditions(qLjkRepay)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
    @ApiOperation(value = "根据channelFinApplyId查询还款信息")
    @GetMapping("/queryRepayByKey")
    fun queryByKey(@RequestParam channelFinApplyId: String): ResVal{
        val resultList: List<LjkRepay>
        try {
            resultList = ljkRepayService.queryRepayByKey(channelFinApplyId)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}