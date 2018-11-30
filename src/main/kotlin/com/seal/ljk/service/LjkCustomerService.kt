package com.seal.ljk.service

import com.seal.ljk.dao.LjkCustomerDao
import com.seal.ljk.model.LjkCustomer
import com.seal.ljk.query.QLjkCustomer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


/**
 * @program: si-server
 *
 * @description: 链金控客户基本信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 10:00
 **/
@Service
class LjkCustomerService {

    @Autowired
    lateinit var ljkCustomerDao: LjkCustomerDao

    fun query(qLjkCustomer: QLjkCustomer): List<LjkCustomer>{
        return ljkCustomerDao.queryCustomer(qLjkCustomer)
    }

}