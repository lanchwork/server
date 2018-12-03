package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkIncomeStatistics
import com.seal.ljk.query.QLjkIncomeStatistics
import com.seal.ljk.service.LjkIncomeStatisticsService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 投资人收益
 * **/
@RestController
@RequestMapping("/ljkIncomeStatistics")
@Api(description = "投资人收益功能相关接口")
class LjkIncomeStatisticsController {

    @Autowired
    lateinit var ljkIncomeStatisticsService: LjkIncomeStatisticsService

    /**
     * 投资人收益统计条件查询
     * **/
    @RequestMapping("/queryLjkIncomeStatistics")
    @ApiOperation(value = "投资人收益统计条件查询")
    fun queryLjkIncomeStatisticsByConditions(@RequestBody qLjkIncomeStatistics: QLjkIncomeStatistics): ResVal {
        val resultList: List<LjkIncomeStatistics>
        try {
            resultList = ljkIncomeStatisticsService.queryLjkIncomeStatisticsByConditions(qLjkIncomeStatistics)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}