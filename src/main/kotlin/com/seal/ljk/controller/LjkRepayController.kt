package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkRepay
import com.seal.ljk.query.QLjkRepay
import com.seal.ljk.service.LjkRepayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 还款信息
 * **/
@RestController
@RequestMapping("/ljkRepay")
class LjkRepayController {

    @Autowired
    lateinit var ljkRepayService: LjkRepayService

    /**
     * 还款信息条件查询
     * **/
    @RequestMapping("/queryLjkRepay")
    fun queryLjkRepayByConditions(@RequestBody qLjkRepay: QLjkRepay): ResVal {
        val resultList: List<LjkRepay>
        try {
            resultList = ljkRepayService.queryLjkRepayByConditions(qLjkRepay)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}