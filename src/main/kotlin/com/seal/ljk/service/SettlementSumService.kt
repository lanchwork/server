package com.seal.ljk.service

import com.seal.ljk.dao.SettlementSumDao
import com.seal.ljk.model.SettlementSum
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SettlementSumService {

    @Autowired
    lateinit var settlementSumDao: SettlementSumDao

    fun getSettlementSumByUser(userNo: String): SettlementSum {
        return settlementSumDao.getSettlementSumByUser(userNo)
    }
}