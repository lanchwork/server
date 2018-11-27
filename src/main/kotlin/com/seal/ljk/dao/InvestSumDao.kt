package com.seal.ljk.dao

import com.seal.ljk.model.InvestSum
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface InvestSumDao {

    @Select("select * from invest_sum where user_no = #{userNo}")
    fun getInvestSumByUser(@Param("userNo") userNo: String): InvestSum?

    @Insert("insert into invest_sum(invest_sum_id, user_no, total_pending_amt, total_invest_amt, earned_amt, unearned_amt, create_date, create_user, update_date, update_user, remark) " +
            "values(#{investSum.investSumId}, #{investSum.userNo}, #{investSum.totalPendingAmt}, #{investSum.totalInvestAmt}, #{investSum.earnedAmt}, #{investSum.unearnedAmt}, #{investSum.createDate}, #{investSum.createUser}, #{investSum.updateDate}, #{investSum.updateUser}, #{investSum.remark})")
    fun createInvestSum(@Param("investSum") investSum: InvestSum)

    @Update("update invest_sum set invest_sum_id=#{investSum.investSumId}, user_no=#{investSum.userNo}, total_pending_amt=#{investSum.totalPendingAmt}, total_invest_amt=#{investSum.totalInvestAmt}, earned_amt=#{investSum.earnedAmt}, unearned_amt=#{investSum.unearnedAmt}, create_date=#{investSum.createDate}, create_user=#{investSum.createUser}, update_date=#{investSum.updateDate}, update_user=#{investSum.updateUser}, remark=#{investSum.remark}" +
            "where invest_sum_id = #{investSum.investSumId}")
    fun updateInvestSumById(@Param("investSum") investSum: InvestSum)
}