package com.seal.ljk.dao

import com.seal.ljk.model.Invest
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface InvestDao {

    @Select("select invest_id,investor_wallet_addr,total_pending_amt,total_invest_amt,earned_amt,unearned_amt,create_date,create_user,update_date,update_user,remark " +
            "from invest where investor_wallet_addr = #{investorWalletAddr}")
    fun getPartnerById(@Param("investorWalletAddr") investorWalletAddr : String): Invest

    @Select("select * from invest where invest_id = #{investId}")
    fun getInvestById(@Param("investId") investId: String): Invest

    @Insert("insert into invest(invest_id, investor_wallet_addr, total_pending_amt, total_invest_amt, earned_amt, unearned_amt, create_date, create_user, update_date, update_user, remark) " +
            "values(#{invest.investId}, #{invest.investorWalletAddr}, #{invest.totalPendingAmt}, #{invest.totalInvestAmt}, #{invest.earnedAmt}, #{invest.unearnedAmt}, #{invest.createDate}, #{invest.createUser}, #{invest.updateDate}, #{invest.updateUser}, #{invest.remark})")
    fun createInvest(@Param("invest") invest: Invest)

    @Update("update invest set invest_id=#{invest.investId}, investor_wallet_addr=#{invest.investorWalletAddr}, total_pending_amt=#{invest.totalPendingAmt}, total_invest_amt=#{invest.totalInvestAmt}, earned_amt=#{invest.earnedAmt}, unearned_amt=#{invest.unearnedAmt}, create_date=#{invest.createDate}, create_user=#{invest.createUser}, update_date=#{invest.updateDate}, update_user=#{invest.updateUser}, remark=#{invest.remark}" +
            "where invest_id = #{invest.investId}")
    fun updateInvestById(@Param("invest") invest: Invest)
}