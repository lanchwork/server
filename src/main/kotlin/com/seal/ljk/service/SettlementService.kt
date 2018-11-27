package com.seal.ljk.service

import com.seal.ljk.dao.SettlementDao
import com.seal.ljk.model.Settlement
import com.seal.ljk.query.QSettlement
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SettlementService {

    @Autowired
    lateinit var settlementDao: SettlementDao

    fun getSettlementListByUserNo(qSettlement: QSettlement): List<Settlement> {
        return settlementDao.getSettlementListByUserNo(qSettlement)
    }
}