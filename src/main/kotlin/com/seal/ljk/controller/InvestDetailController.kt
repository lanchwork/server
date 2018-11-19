package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.InvestDetail
import com.seal.ljk.model.InvestDetailList
import com.seal.ljk.query.QInvestDetail
import com.seal.ljk.service.InvestDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/investDetail")
class InvestDetailController {

    @Autowired
    lateinit var investDetailService: InvestDetailService

    /*投资已还款列表查询*/
    @GetMapping("/list")
    fun getRepaymentList(@RequestParam investorWalletAddr: String,@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val resultList: InvestDetailList
        val currentPageNew = (currentPage - 1) * pageSize
        try {
            resultList=investDetailService.getRepaymentList(investorWalletAddr,currentPageNew, pageSize)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    @PostMapping("/walletInvestDetail")
    fun queryWalletInvestDetail(@RequestBody qInvestDetail: QInvestDetail): ResVal {
        val resultList: List<InvestDetail>
        try {
            resultList = investDetailService.queryWalletInvestDetail(qInvestDetail)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    @PostMapping("/paybackInvestDetail")
    fun queryPaybackInvestDetail(@RequestBody qInvestDetail: QInvestDetail): ResVal {
        val resultList: List<InvestDetail>
        try {
            resultList = investDetailService.queryPaybackInvestDetail(qInvestDetail)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

}