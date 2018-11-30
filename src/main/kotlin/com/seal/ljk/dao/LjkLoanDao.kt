package com.seal.ljk.dao

import com.seal.ljk.model.LjkLoan
import com.seal.ljk.provider.LjkLoanProvider
import com.seal.ljk.query.QLjkLoan
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkLoanDao {

    @SelectProvider(type = LjkLoanProvider::class, method = "queryLjkLoanByConditions")
    fun queryByConditions(qLjkLoan: QLjkLoan): List<LjkLoan>

    @Select("select * from ljk_loan where channel_fin_apply_id=#{channelFinApplyId}")
    fun queryLoanByKey(channelFinApplyId: String): List<LjkLoan>
}
