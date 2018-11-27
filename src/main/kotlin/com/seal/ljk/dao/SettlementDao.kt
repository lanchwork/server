package com.seal.ljk.dao

import com.seal.ljk.model.InvestSettlement
import com.seal.ljk.model.Settlement
import com.seal.ljk.provider.SettlementProvider
import com.seal.ljk.query.QSettlement
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface SettlementDao {

    @SelectProvider(type = SettlementProvider::class, method = "getSettlementListByUserNo")
    fun getSettlementListByUserNo(qSettlement: QSettlement): List<Settlement>

    @SelectProvider(type = SettlementProvider::class, method = "querySettlementByConditions")
    fun querySettlementByConditions(qSettlement: QSettlement): List<InvestSettlement>
}