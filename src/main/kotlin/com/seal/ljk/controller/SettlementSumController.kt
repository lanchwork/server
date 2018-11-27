package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.SettlementSum
import com.seal.ljk.service.SettlementSumService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/settlementSum")
class SettlementSumController {

    @Autowired
    lateinit var settlementSumService: SettlementSumService

    /**
     * 结算统计数据
     */
    @GetMapping("/byUser")
    fun getSettlementSumByUser(@RequestParam userNo: String): ResVal {
        val result: SettlementSum
        try {
            result = settlementSumService.getSettlementSumByUser(userNo)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, result)
    }
}