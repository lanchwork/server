package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkCollection
import com.seal.ljk.query.QLjkCollection
import com.seal.ljk.service.LjkCollectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 催收信息
 * **/
@RestController
@RequestMapping("/ljkCollection")
class LjkCollectionController {

    @Autowired
    lateinit var ljkCollectionService: LjkCollectionService

    /**
     * 催收信息条件查询
     * **/
    @RequestMapping("/queryLjkCollection")
    fun queryLjkCollectionByConditions(@RequestBody qLjkCollection: QLjkCollection): ResVal {
        val resultList: List<LjkCollection>
        try {
            resultList = ljkCollectionService.queryLjkCollectionByConditions(qLjkCollection)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}