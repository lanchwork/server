package com.seal.ljk.controller

import com.seal.ljk.Query.QloanDetail
import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LoanDetail
import com.seal.ljk.service.LoanDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/loanDetail")
class LoanDetailController {

    @Autowired
    lateinit var loanDetailService: LoanDetailService

    @RequestMapping("/query")
    fun query(@RequestBody qLoanDetail: QloanDetail): ResVal{
        val resultList: List<LoanDetail>
        try {
            resultList = loanDetailService.query(qLoanDetail)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
}