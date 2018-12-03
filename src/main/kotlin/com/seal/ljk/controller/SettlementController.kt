package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.InvestSettlement
import com.seal.ljk.model.Settlement
import com.seal.ljk.query.QSettlement
import com.seal.ljk.service.SettlementService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/settlement")
@Api(description = "结算功能相关接口")
class SettlementController {

    @Autowired
    lateinit var settlementService: SettlementService

    /**
     * 根据用户标识查询待结算明细
     * */
    @RequestMapping("/getSettlementList")
    @ApiOperation(value = "根据用户标识查询待结算明细")
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
     * 申请结算
     */
    @RequestMapping("/apply")
    fun saveApplySettlement(@RequestBody data: Map<String, Any>): ResVal {
        try {
            settlementService.saveApplySettlement(data)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "SUCCESS")
    }

    /***
     * 结算
     */
    @RequestMapping("/want")
    fun saveWantSettlement(@RequestBody data: Map<String, Any>): ResVal {
        try {
            settlementService.saveWantSettlement(data)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "SUCCESS")
    }

    /**
     *  结算待处理明细条件查询
     * */
    @RequestMapping("/querySettlementList")
    @ApiOperation(value = "结算待处理明细条件查询")
    fun querySettlementByConditions(@RequestBody qSettlement: QSettlement): ResVal {
        val resultList: List<InvestSettlement>
        try {
            resultList = settlementService.querySettlementByConditions(qSettlement)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
}