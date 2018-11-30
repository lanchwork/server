package com.seal.ljk.service

import com.seal.ljk.dao.LjkRiskDetailDao
import com.seal.ljk.model.LjkRiskDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


/**
 * @program: si-server
 *
 * @description: 链金控风控详细信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 11:52
 **/
@Service
class LjkRiskDetailService {

    @Autowired
    lateinit var ljkRiskDetailDao: LjkRiskDetailDao

    fun getRiskDetailByKey(riskCalculateId: String): List<LjkRiskDetail>{
        return ljkRiskDetailDao.getRiskDetailByKey(riskCalculateId)
    }
}