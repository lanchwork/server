package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.InvestLoan
import com.seal.ljk.model.LoanList
import com.seal.ljk.query.QLoan
import com.seal.ljk.service.LoanService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/loan")
@Api(description = "放款功能相关接口")
class LoanController {

    @Autowired
    lateinit var loanService: LoanService

    /**
     *  根据投资编号查询放款明细
     * */
    @RequestMapping("/getLoanList")
    @ApiOperation(value = "根据投资编号查询放款明细")
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
    @ApiOperation(value = "实际放款明细条件查询")
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