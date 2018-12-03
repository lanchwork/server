package com.seal.ljk.controller


import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkOperationalStatistics
import com.seal.ljk.query.QLjkOperationalStatistics
import com.seal.ljk.service.LjkOperationalStatisticsService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *  平台运营
 * **/
@RestController
@RequestMapping("/ljkOperationalStatistics")
@Api(description = "平台运营功能相关接口")
class LjkOperationalStatisticsController {

    @Autowired
    lateinit var ljkOperationalStatisticsService: LjkOperationalStatisticsService

    /**
     * 平台运营统计条件查询
     * **/
    @RequestMapping("/queryLjkOperationalStatistics")
    @ApiOperation(value = "平台运营统计条件查询")
    fun queryLjkOperationalStatisticsByConditions(@RequestBody qLjkOperationalStatistics: QLjkOperationalStatistics): ResVal {
        val resultList: List<LjkOperationalStatistics>
        try {
            resultList = ljkOperationalStatisticsService.queryLjkOperationalStatisticsByConditions(qLjkOperationalStatistics)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}