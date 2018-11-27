package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.InvestSum
import com.seal.ljk.service.InvestSumService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/investSum")
class InvestSumController {

    @Autowired
    lateinit var investSumService: InvestSumService

    /**
     * 收益统计数据
     */
    @GetMapping("/byUser")
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
    @RequestMapping("/want")
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