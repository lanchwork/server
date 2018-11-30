package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkLoan
import com.seal.ljk.query.QLjkLoan
import com.seal.ljk.service.LjkLoanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 放款信息
 * **/
@RestController
@RequestMapping("/ljkLoan")
class LjkLoanController {

    @Autowired
    lateinit var ljkLoanService: LjkLoanService

    /**
     * 放款信息条件查询
     * **/
    @RequestMapping("/queryLjkLoan")
    fun queryLjkLoanByConditions(@RequestBody qLjkLoan: QLjkLoan): ResVal {
        val resultList: List<LjkLoan>
        try {
            resultList = ljkLoanService.queryLjkLoanByConditions(qLjkLoan)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}