package com.seal.ljk.controller

import com.seal.ljk.base.logger
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkCollection
import com.seal.ljk.model.LjkOverdue
import com.seal.ljk.query.QLjkOverdue
import com.seal.ljk.service.LjkOverdueService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 逾期信息
 * **/
@RestController
@RequestMapping("/ljkOverdue")
@Api(description = "逾期信息功能相关接口")
class LjkOverdueController {

    @Autowired
    lateinit var ljkOverdueService: LjkOverdueService

    /**
     * 逾期信息条件查询
     * **/
    @PostMapping("/queryLjkOverdue")
    @ApiOperation(value = "逾期信息条件查询")
    fun queryLjkOverdueByConditions(@RequestBody qLjkOverdue: QLjkOverdue): ResVal {
        val resultList: List<LjkOverdue>
        try {
            resultList = ljkOverdueService.queryLjkOverdueByConditions(qLjkOverdue)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    /**
     * 根据逾期编号id查看催收信息
     * **/
    @PostMapping("/getLjkCollection")
    @ApiOperation(value = "根据逾期编号查看催收信息")
    fun getLjkCollectionByConditions(@RequestBody qLjkOverdue: QLjkOverdue): ResVal {
        val resultList: List<LjkCollection>
        try {
            resultList = ljkOverdueService.getLjkCollectionByConditions(qLjkOverdue)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}