package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkInvest
import com.seal.ljk.query.QLjkInvest
import com.seal.ljk.service.LjkInvestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 投资信息
 * **/
@RestController
@RequestMapping("/ljkInvest")
class LjkInvestController {

    @Autowired
    lateinit var ljkInvestService: LjkInvestService

    /**
     * 投资信息条件查询
     * **/
    @RequestMapping("/queryLjkInvest")
    fun queryLjkInvestByConditions(@RequestBody qLjkInvest: QLjkInvest): ResVal {
        val resultList: List<LjkInvest>
        try {
            resultList = ljkInvestService.queryLjkInvestByConditions(qLjkInvest)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}