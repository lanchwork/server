package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Reconciliation
import com.seal.ljk.query.QReconciliation
import com.seal.ljk.service.ReconciliationService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/reconciliation")
@Api(description = "对账功能相关接口")
class ReconciliationController {

    @Autowired
    lateinit var reconciliationService: ReconciliationService

    @PostMapping("/all")
    @ApiOperation(value = "获取所有对账")
    fun getAllReconciliation(): ResVal {
        val resultList: List<Reconciliation>
        try {
            resultList = reconciliationService.getAllReconciliation()
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    @PostMapping("/getById")
    @ApiOperation(value = "根据id获取对账")
    fun getReconciliationById(@RequestParam partnerId: String): ResVal {
        val result: Reconciliation
        try {
            result = reconciliationService.getReconciliationById(partnerId)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, result)
    }

    @PostMapping("/list")
    @ApiOperation(value = "查询对账列表")
    fun getReconciliationList(@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val resultList: List<Reconciliation>
        val currentPageNew = (currentPage - 1) * pageSize
        try {
            resultList = reconciliationService.getReconciliationList(currentPageNew, pageSize)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    @PostMapping("/byCondition")
    @ApiOperation(value = "条件查询对账")
    fun getReconciliationByCondition(@RequestBody qReconciliation: QReconciliation): ResVal {
        val resultList: List<Reconciliation>
        try {
            resultList = reconciliationService.getReconciliationByCondition(qReconciliation)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
    
}