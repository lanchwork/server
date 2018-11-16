package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.dao.LoanDao
import com.seal.ljk.dao.ProtocolDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/loan")
class LoanController {


    @Autowired
    lateinit var loanDao: LoanDao

    /*借款利息支付统计查询*/
    @GetMapping("/getById")
    fun getPartnerById(@RequestParam loanerWalletAddr: String): ResVal {
        try {
            loanDao.getPartnerById(loanerWalletAddr)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, loanDao.getPartnerById(loanerWalletAddr))
    }


}