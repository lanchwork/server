package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
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
        try {
            reconciliationService.getAllReconciliation()
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, reconciliationService.getAllReconciliation())
    }

    @GetMapping("/getById")
    fun getReconciliationById(@RequestParam partnerId: String): ResVal {
        try {
            reconciliationService.getReconciliationById(partnerId)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, reconciliationService.getReconciliationById(partnerId))
    }

    @GetMapping("/list")
    fun getReconciliationList(@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val currentPageNew = (currentPage - 1) * pageSize
        try {
            reconciliationService.getReconciliationList(currentPageNew, pageSize)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, reconciliationService.getReconciliationList(currentPageNew, pageSize))
    }
}