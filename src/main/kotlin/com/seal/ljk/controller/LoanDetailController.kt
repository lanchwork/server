package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LoanDetail
import com.seal.ljk.service.LoanDetailServise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception


@RestController
@RequestMapping("/loanDetail")
class LoanDetailController {

    @Autowired
    lateinit var loanDetailService:LoanDetailServise

    /*投资已还款列表查询*/
    @GetMapping("/list")
    fun getRepaymentList(@RequestParam partnerWalletAddr: String, @RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val currentPageNew = (currentPage - 1) * pageSize
        var resultList : List<LoanDetail>
        try {
           resultList = loanDetailService.getRepaymentList(partnerWalletAddr,currentPageNew,pageSize)
        }catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }

        return ResVal(0,resultList)
    }
}