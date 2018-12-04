package com.seal.ljk.controller


import com.seal.ljk.base.logger
import com.seal.ljk.common.ResVal
import com.seal.ljk.service.PlatformStatisticsService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/platformStatistics")
@Api(description = "平台统计信息功能相关")
class PlatformStatisticsController {


    @Autowired
    lateinit var platformStatisticsService: PlatformStatisticsService

    /**
     * 平台统计信息查询
     */
    @PostMapping("/getLast")
    @ApiOperation(value = "平台统计信息查询")
    fun getPlatformStatisticsLast(): ResVal{

        var platformStatistic=  platformStatisticsService.getPlatformStatisticsLast()
        return ResVal(0, platformStatistic)
    }


    /**
     * 新增平台统计信息
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增平台统计信息")
    fun createPlatformStatistics():ResVal{
        try {
            platformStatisticsService.createPlatformStatistics()
        }catch (e: Exception){
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")

    }




}