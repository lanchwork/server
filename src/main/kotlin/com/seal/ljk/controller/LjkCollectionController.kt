package com.seal.ljk.controller

import com.seal.ljk.base.logger
import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkCollection
import com.seal.ljk.query.QLjkCollection
import com.seal.ljk.service.LjkCollectionService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 催收信息
 * **/
@RestController
@RequestMapping("/ljkCollection")
@Api(description = "催收信息功能相关接口")
class LjkCollectionController {

    @Autowired
    lateinit var ljkCollectionService: LjkCollectionService

    /**
     * 催收信息条件查询
     * **/
    @PostMapping("/queryLjkCollection")
    @ApiOperation(value = "催收信息条件查询")
    fun queryLjkCollectionByConditions(@RequestBody qLjkCollection: QLjkCollection): ResVal {
        val resultList: List<LjkCollection>
        try {
            resultList = ljkCollectionService.queryLjkCollectionByConditions(qLjkCollection)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}