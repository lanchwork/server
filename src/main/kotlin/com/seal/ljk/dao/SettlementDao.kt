package com.seal.ljk.dao

import com.seal.ljk.model.InvestSettlement
import com.seal.ljk.model.Settlement
import com.seal.ljk.provider.SettlementProvider
import com.seal.ljk.query.QSettlement
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface SettlementDao {

    @SelectProvider(type = SettlementProvider::class, method = "getSettlementListByUserNo")
    fun getSettlementListByUserNo(qSettlement: QSettlement): List<Settlement>

    @SelectProvider(type = SettlementProvider::class, method = "querySettlementByConditions")
    fun querySettlementByConditions(qSettlement: QSettlement): List<InvestSettlement>

    @Select("select sum(apply_settle_amt) FROM settlement where invest_no=#{investNo}")
    fun getApplySettleAmtSum(investNo: String): BigDecimal


}