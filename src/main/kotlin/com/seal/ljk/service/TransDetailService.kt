package com.seal.ljk.service

import com.seal.ljk.dao.TransDetailDao
import com.seal.ljk.model.TransDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransDetailService {

    @Autowired
    lateinit var transDetailDao: TransDetailDao

    /*fun getTransDetailList(currentPage : Int, pageSize : Int):List<TransDetail>{
        return transDetailDao.getTransDetailList(currentPage,pageSize);
    }*/
}