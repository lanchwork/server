package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkRiskDetail
import com.seal.ljk.service.LjkRiskDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


/**
 * @program: si-server
 *
 * @description: 链金控风控详细信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 11:54
 **/
@RestController
@RequestMapping("/ljkRiskDetail")
class LjkRiskDetailController {

    @Autowired
    lateinit var ljkRiskDetailService: LjkRiskDetailService

    @GetMapping("/getRiskDetailByKey")
    fun getRiskDetailByKey(@RequestParam riskCalculateId: String): ResVal{
        val resultList: List<LjkRiskDetail>
        try {
            resultList = ljkRiskDetailService.getRiskDetailByKey(riskCalculateId)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
}