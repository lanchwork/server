package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkLoan
import com.seal.ljk.query.QLjkLoan
import com.seal.ljk.service.LjkLoanService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 放款信息
 * **/
@RestController
@RequestMapping("/ljkLoan")
@Api(description = "xxxx功能相关接口")
class LjkLoanController {

    @Autowired
    lateinit var ljkLoanService: LjkLoanService

    /**
     * 放款信息条件查询
     * **/
    @ApiOperation(value = "放款信息条件查询")
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
    @ApiOperation(value = "xxxx查询")
    @GetMapping("queryLoanByKey")
    fun queryByKey(@RequestParam channelFinApplyId: String): ResVal{
        val resultList: List<LjkLoan>
        try {
            resultList = ljkLoanService.queryLoanByKey(channelFinApplyId)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}