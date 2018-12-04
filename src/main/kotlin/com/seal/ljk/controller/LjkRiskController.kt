package com.seal.ljk.controller

import com.seal.ljk.base.logger
import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkRisk
import com.seal.ljk.query.QLjkRisk
import com.seal.ljk.service.LjkRiskService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
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
@RequestMapping("/ljkRisk")
@Api(description = "风控基本信息功能相关接口")
class LjkRiskController {

    @Autowired
    lateinit var ljkRiskService: LjkRiskService

    @PostMapping("/queryRisk")
    @ApiOperation(value = "查询风控基本信息")
    fun query(@RequestBody qLjkRisk: QLjkRisk): ResVal{
        val resultList: List<LjkRisk>
        try {
            resultList = ljkRiskService.query(qLjkRisk)
        } catch (e: Exception){
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
}