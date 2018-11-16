package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Reconciliation
import com.seal.ljk.service.ReconciliationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reconciliation")
class ReconciliationController {

    @Autowired
    lateinit var reconciliationService: ReconciliationService

    @GetMapping("/all")
    fun getAllReconciliation(): ResVal {
        val resultList: List<Reconciliation>
        try {
            resultList = reconciliationService.getAllReconciliation()
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    @GetMapping("/getById")
    fun getReconciliationById(@RequestParam partnerId: String): ResVal {
        val result: Reconciliation
        try {
            result = reconciliationService.getReconciliationById(partnerId)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, result)
    }

    @GetMapping("/list")
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
}