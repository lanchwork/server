package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.dao.TransDetailDao
import com.seal.ljk.model.TransDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transDetail")
class TransDetailController {

    /*@Autowired
    lateinit var transDetailService: TransDetailService*/
    @Autowired
    lateinit var transDetailDao: TransDetailDao

    @GetMapping("/list")
    fun getPartnerList(@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val currentPageNew = (currentPage - 1) * pageSize
        val transDetailList : List<TransDetail>
        try {
            transDetailList = transDetailDao.getTransDetailList(currentPageNew, pageSize)
        } catch (e: Exception) {
            println(e)
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, transDetailList)
    }

}