package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkRisk
import com.seal.ljk.query.QLjkRisk
import com.seal.ljk.service.LjkRiskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * @program: si-server
 *
 * @description: 链金控风控基本信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 10:38
 **/
@RestController
@RequestMapping("/api/seal/")
class LjkRiskController {

    @Autowired
    lateinit var ljkRiskService: LjkRiskService

    @RequestMapping("queryRisk")
    fun query(@RequestBody qLjkRisk: QLjkRisk): ResVal{
        val resultList: List<LjkRisk>
        try {
            resultList = ljkRiskService.query(qLjkRisk)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
}