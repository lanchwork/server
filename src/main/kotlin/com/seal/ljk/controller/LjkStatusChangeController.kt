package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkStatusChange
import com.seal.ljk.query.QLjkStatusChange
import com.seal.ljk.service.LjkStatusChangeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 状态迁变
 * **/
@RestController
@RequestMapping("/ljkStatusChange")
class LjkStatusChangeController {

    @Autowired
    lateinit var ljkStatusChangeService: LjkStatusChangeService

    /**
     * 状态迁变条件查询
     * **/
    @RequestMapping("/queryLjkStatusChange")
    fun queryLjkStatusChangeByConditions(@RequestBody qLjkStatusChange: QLjkStatusChange): ResVal {
        val resultList: List<LjkStatusChange>
        try {
            resultList = ljkStatusChangeService.queryLjkStatusChangeByConditions(qLjkStatusChange)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}