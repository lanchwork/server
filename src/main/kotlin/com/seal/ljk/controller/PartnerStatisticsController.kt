package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.service.PartnerStatisticsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


/**
 * @description: 合作方的统计信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-26 14:26
 **/
@RestController
@RequestMapping("/partner")
class PartnerStatisticsController {

    @Autowired
    lateinit var partnerStatisticsService: PartnerStatisticsService

    @GetMapping("/getStatistics")
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