package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.InvestLoan
import com.seal.ljk.model.LoanList
import com.seal.ljk.query.QLoan
import com.seal.ljk.service.LoanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/loan")
class LoanController {

    @Autowired
    lateinit var loanService: LoanService

    /**
     *  根据投资编号查询放款明细
     * */
    @RequestMapping("/getLoanList")
    fun getLoanListByInvestNo(@RequestBody qLoan: QLoan): ResVal {
        val resultList: LoanList
        try {
            resultList = loanService.getLoanListByInvestNo(qLoan)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    /**
     *  实际放款明细条件查询
     * */
    @RequestMapping("/queryInvestLoanList")
    fun queryInvestLoanByConditions(@RequestBody qLoan: QLoan): ResVal {
        val resultList: List<InvestLoan>
        try {
            resultList = loanService.queryInvestLoanByConditions(qLoan)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}