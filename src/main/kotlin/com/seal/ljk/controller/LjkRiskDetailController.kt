package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkRiskDetail
import com.seal.ljk.service.LjkRiskDetailService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


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
@Api(description = "风控详细信息功能相关接口")
class LjkRiskDetailController {

    @Autowired
    lateinit var ljkRiskDetailService: LjkRiskDetailService

    @PostMapping("/getRiskDetailByKey")
    @ApiOperation(value = "查询风控详细信息")
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