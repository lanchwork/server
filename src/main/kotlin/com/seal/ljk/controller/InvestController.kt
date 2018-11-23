package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Invest
import com.seal.ljk.model.InvestDetail
import com.seal.ljk.model.InvestDetailList
import com.seal.ljk.model.Loan
import com.seal.ljk.query.QInvestDetail
import com.seal.ljk.service.InvestDetailService
import com.seal.ljk.service.InvestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/invest")
class InvestController {

    @Autowired
    lateinit var investService: InvestService

    /**
     * 投资收益统计数据查询
     */
    @GetMapping("/getById")
    fun getPartnerById(@RequestParam investorWalletAddr: String): ResVal {
        val result: Invest
        try {
            result=investService.getPartnerById(investorWalletAddr)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, result)
    }

    /***
     * 我要投资
     */
    @RequestMapping("/want")
    fun saveWantInvest(@RequestBody data: Map<String, Any>): ResVal {
        try {
            investService.saveWantInvest(data)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "SUCCESS")
    }
}