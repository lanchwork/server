package com.seal.ljk.dao

import com.seal.ljk.model.LjkLoan
import com.seal.ljk.provider.LjkLoanProvider
import com.seal.ljk.query.QLjkLoan
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkLoanDao {

    @SelectProvider(type = LjkLoanProvider::class, method = "queryLjkLoanByConditions")
    fun queryByConditions(qLjkLoan: QLjkLoan): List<LjkLoan>

}
