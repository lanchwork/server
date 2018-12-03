package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.service.PartnerStatisticsService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


/**
 * @description: 合作方的统计信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-26 14:26
 **/
@RestController
@RequestMapping("/partner")
@Api(description = "合作方统计信息的功能相关接口")
class PartnerStatisticsController {

    @Autowired
    lateinit var partnerStatisticsService: PartnerStatisticsService

    @PostMapping("/getStatistics")
    @ApiOperation(value = "获取合作方ID为partnerId的合作方统计信息")
    fun getPartnerStatistics(@RequestParam partnerId: String):ResVal{
        var resMap = mapOf<String, Any>()
        try {
            resMap = partnerStatisticsService.DoPartnerStatisticsApi(partnerId)
        } catch (e: Exception){
            e.printStackTrace()
        }
        return ResVal(0, resMap)
    }

}