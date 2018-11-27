package com.seal.ljk.dao

import com.seal.ljk.model.SettlementSum
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface SettlementSumDao {

    @Select("select total_to_settle_amt, total_settled_amt, paid_profit， to_pay_profit from settlement_sum where user_no = #{userNo}")
    fun getSettlementSumByUser(@Param("userNo") userNo: String): SettlementSum
}