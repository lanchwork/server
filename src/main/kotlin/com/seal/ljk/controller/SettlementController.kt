package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Settlement
import com.seal.ljk.query.QSettlement
import com.seal.ljk.service.SettlementService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/settlement")
class SettlementController {

    @Autowired
    lateinit var settlementService: SettlementService

    /**
     * 根据用户标识查询待结算明细
     * */
    @RequestMapping("/getSettlementList")
    fun getSettlementListByUserNo(@RequestBody qSettlement: QSettlement): ResVal {
        val resultList: List<Settlement>
        try {
            resultList = settlementService.getSettlementListByUserNo(qSettlement)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    /***
     * 结算
     */
    @RequestMapping("/want")
    fun saveWantInvest(@RequestBody data: Map<String, Any>): ResVal {
        try {
            settlementService.saveWantSettlement(data)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "SUCCESS")
    }
}