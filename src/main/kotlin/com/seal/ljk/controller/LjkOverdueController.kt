package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkOverdue
import com.seal.ljk.query.QLjkOverdue
import com.seal.ljk.service.LjkOverdueService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}