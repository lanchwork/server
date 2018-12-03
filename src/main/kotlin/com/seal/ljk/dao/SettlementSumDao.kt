package com.seal.ljk.dao

import com.seal.ljk.model.SettlementSum
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface SettlementSumDao {

    @Select("select * from lc_settlement_sum where user_no = #{userNo}")
    fun getSettlementSumByUser(@Param("userNo") userNo: String): SettlementSum?

    @Insert("insert into lc_settlement_sum(settlement_sum_id, user_no, total_to_settle_amt, total_settled_amt, paid_profit, to_pay_profit, create_date, create_user, update_date, update_user, remark) " +
            "values(#{settlementSum.settlementSumId}, #{settlementSum.userNo}, #{settlementSum.totalToSettleAmt}, #{settlementSum.totalSettledAmt}, #{settlementSum.paidProfit}, #{settlementSum.toPayProfit}, #{settlementSum.createDate}, #{settlementSum.createUser}, #{settlementSum.updateDate}, #{settlementSum.updateUser}, #{settlementSum.remark})")
    fun createSettlementSum(@Param("settlementSum") settlementSum: SettlementSum)

    @Update("update lc_settlement_sum set settlement_sum_id=#{settlementSum.settlementSumId}, user_no=#{settlementSum.userNo}, total_to_settle_amt=#{settlementSum.totalToSettleAmt}, total_settled_amt=#{settlementSum.totalSettledAmt}, paid_profit=#{settlementSum.paidProfit}, to_pay_profit=#{settlementSum.toPayProfit}, create_date=#{settlementSum.createDate}, create_user=#{settlementSum.createUser}, update_date=#{settlementSum.updateDate}, update_user=#{settlementSum.updateUser}, remark=#{settlementSum.remark}" +
            "where settlement_sum_id = #{settlementSum.settlementSumId}")
    fun updateSettlementSumById(@Param("settlementSum") settlementSum: SettlementSum)
}
