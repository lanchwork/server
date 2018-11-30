package com.seal.ljk.service

import com.seal.ljk.dao.LjkRiskDao
import com.seal.ljk.model.LjkRisk
import com.seal.ljk.query.QLjkRisk
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


/**
 * @program: si-server
 *
 * @description: 链金控风控基本信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 10:35
 **/
@Service
class LjkRiskService {

    @Autowired
    lateinit var ljkRiskDao: LjkRiskDao

    fun query(qLjkRisk: QLjkRisk): List<LjkRisk>{
        return ljkRiskDao.queryLjkRisk(qLjkRisk)
    }
}