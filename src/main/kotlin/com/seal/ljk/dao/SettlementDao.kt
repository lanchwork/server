package com.seal.ljk.dao

import com.seal.ljk.model.InvestSettlement
import com.seal.ljk.model.Settlement
import com.seal.ljk.provider.SettlementProvider
import com.seal.ljk.query.QSettlement
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface SettlementDao {

    @SelectProvider(type = SettlementProvider::class, method = "getSettlementListByUserNo")
    fun getSettlementListByUserNo(qSettlement: QSettlement): List<Settlement>

    @SelectProvider(type = SettlementProvider::class, method = "querySettlementByConditions")
    fun querySettlementByConditions(qSettlement: QSettlement): List<InvestSettlement>

    @Select("select sum(apply_settle_amt) FROM lc_settlement where invest_no=#{investNo}")
    fun getApplySettleAmtSum(@Param("investNo") investNo: String): BigDecimal

    @Select("select * from lc_settlement where settlement_id = #{settlementId} ")
    fun getSettlementById(@Param("settlementId") settlementId: String): Settlement

    @Insert("insert into lc_settlement(settlement_id, user_no, invest_no, apply_settle_amt, apply_time, settle_principal, investor_profit, seal_profit, status, settle_time, chain_trans_no, partner_id, partnerWalletAddr, investorWalletAddr, sealWalletAddr, create_date, create_user, update_date, update_user, remark)" +
            " values(#{settlement.settlementId}, #{settlement.userNo}, #{settlement.investNo}, #{settlement.applySettleAmt}, #{settlement.applyTime}, #{settlement.settlePrincipal}, #{settlement.investorProfit}, #{settlement.sealProfit}, #{settlement.status}, #{settlement.settleTime}, #{settlement.chainTransNo}, #{settlement.partnerId}, #{settlement.partnerWalletAddr}, #{settlement.investorWalletAddr}, #{settlement.sealWalletAddr}, #{settlement.createDate}, #{settlement.createUser}, #{settlement.updateDate}, #{settlement.updateUser}, #{settlement.remark})")
    fun createSettlement(@Param("settlement") settlement: Settlement)

    @Update("update lc_settlement set settlement_id=#{settlement.settlementId}, user_no=#{settlement.userNo}, invest_no=#{settlement.investNo}, apply_settle_amt=#{settlement.applySettleAmt}, apply_time=#{settlement.applyTime}, settle_principal=#{settlement.settlePrincipal}, investor_profit=#{settlement.investorProfit}, seal_profit=#{settlement.sealProfit}, status=#{settlement.status}, settle_time=#{settlement.settleTime}, chain_trans_no=#{settlement.chainTransNo}, partner_id=#{settlement.partnerId}, partnerWalletAddr=#{settlement.partnerWalletAddr}, investorWalletAddr=#{settlement.investorWalletAddr}, sealWalletAddr=#{settlement.sealWalletAddr}, create_date=#{settlement.createDate}, create_user=#{settlement.createUser}, update_date=#{settlement.updateDate}, update_user=#{settlement.updateUser}, remark=#{settlement.remark} " +
            " where settlement_id = #{settlement.settlementId}")
    fun updateSettlementById(@Param("settlement") settlement: Settlement)
}