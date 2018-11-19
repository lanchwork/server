package com.seal.ljk.controller

import com.seal.ljk.query.QLoanDetail
import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LoanDetail
import com.seal.ljk.service.LoanDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception


@RestController
@RequestMapping("/loanDetail")
class LoanDetailController {

    @Autowired
    lateinit var loanDetailService: LoanDetailService

    /*借款已还款列表查询*/
    @GetMapping("/list")
    fun getRepaymentList(@RequestParam partnerWalletAddr: String, @RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val currentPageNew = (currentPage - 1) * pageSize
        val resultList : List<LoanDetail>
        try {
           resultList = loanDetailService.getRepaymentList(partnerWalletAddr,currentPageNew,pageSize)
        }catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }

        return ResVal(0,resultList)
    }

    @RequestMapping("query")
    fun query(@RequestBody qLoanDetail: QLoanDetail): ResVal{
        val resultList: List<LoanDetail>
        try {
            resultList = loanDetailService.query(qLoanDetail)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
    /**
     * 生成未还款列表
     * @param partnerId 根据合作方Id查询
     * @author lanch
     */
    @PostMapping("/listNoRepay")
    fun getNotRepaymentList(@RequestParam partnerId : String): ResVal{

        var resultList : List<LoanDetail>
        try {
            resultList = loanDetailService.getNotRepayList(partnerId)
        }catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }

        return ResVal(0,resultList)
    }
}