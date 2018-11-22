package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Loan
import com.seal.ljk.service.LoanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/loan")
class LoanController {


    @Autowired
    lateinit var loanService: LoanService

    /*借款利息支付统计查询*/
    @GetMapping("/getById")
    fun getPartnerById(@RequestParam loanerWalletAddr: String): ResVal {
        val result: Loan
        try {
            result=loanService.getPartnerById(loanerWalletAddr)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, result)
    }

    /***
     * 我要还款
     */
    @RequestMapping("/want")
    fun saveWantRepay(@RequestBody data: Map<String, Any>): ResVal {
        try {
            loanService.saveWantRepay(data)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "SUCCESS")
    }

}