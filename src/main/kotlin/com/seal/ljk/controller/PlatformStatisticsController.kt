package com.seal.ljk.controller


import com.seal.ljk.common.ResVal
import com.seal.ljk.model.InvestDetail
import com.seal.ljk.service.PlatformStatisticsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/platformStatistics")
class PlatformStatisticsController {


    @Autowired
    lateinit var platformStatisticsService: PlatformStatisticsService

    /**
     * 平台统计信息查询
     */
    @GetMapping("/getLast")
    fun getPlatformStatisticsLast(): ResVal{

        var platformStatistic=  platformStatisticsService.getPlatformStatisticsLast()
        return ResVal(0, platformStatistic)
    }


    /**
     * 新增平台统计信息
     */
    @RequestMapping("/add")
    fun createPlatformStatistics():ResVal{
        try {
            platformStatisticsService.createPlatformStatistics()
        }catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")

    }




}