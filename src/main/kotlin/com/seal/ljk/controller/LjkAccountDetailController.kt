package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkAccountDetail
import com.seal.ljk.query.QLjkAccountDetail
import com.seal.ljk.service.LjkAccountDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 平台资金账户明细
 * **/
@RestController
@RequestMapping("/ljkAccountDetail")
class LjkAccountDetailController {

    @Autowired
    lateinit var ljkAccountDetailService: LjkAccountDetailService

    /**
     * 平台资金账户明细条件查询
     * **/
    @RequestMapping("/queryLjkAccountDetail")
    fun queryLjkAccountDetailByConditions(@RequestBody qLjkAccountDetail: QLjkAccountDetail): ResVal {
        val resultList: List<LjkAccountDetail>
        try {
            resultList = ljkAccountDetailService.queryLjkAccountDetailByConditions(qLjkAccountDetail)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}