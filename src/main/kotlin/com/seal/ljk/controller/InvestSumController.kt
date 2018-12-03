package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.InvestSum
import com.seal.ljk.service.InvestSumService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/investSum")
@Api(description = "投资汇总相关功能接口")
class InvestSumController {

    @Autowired
    lateinit var investSumService: InvestSumService

    /**
     * 收益统计数据
     */
    @PostMapping("/byUser")
    @ApiOperation(value = "根据用户获取收益统计数据")
    fun getInvestSumByUser(@RequestParam userNo: String): ResVal {
        val result: InvestSum
        try {
            result = investSumService.getInvestSumByUser(userNo)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, result)
    }

    /***
     * 我要投资
     */
    @PostMapping("/want")
    @ApiOperation(value = "授权投资功能")
    fun saveWantInvest(@RequestBody data: Map<String, Any>): ResVal {
        try {
            investSumService.saveWantInvest(data)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "SUCCESS")
    }
}