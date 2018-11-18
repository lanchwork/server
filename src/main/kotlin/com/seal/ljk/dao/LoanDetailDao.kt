package com.seal.ljk.dao

import com.seal.ljk.Provider.LoanDetailProvider
import com.seal.ljk.Query.QloanDetail
import com.seal.ljk.model.LoanDetail
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LoanDetailDao {

    @SelectProvider(type = LoanDetailProvider::class, method = "queryLoanDetail")
    fun queryByProvider(qLoanDetail: QloanDetail): List<LoanDetail>

}