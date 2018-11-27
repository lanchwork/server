package com.seal.ljk.dao

import com.seal.ljk.model.InvestLoan
import com.seal.ljk.model.Loan
import com.seal.ljk.provider.LoanProvider
import com.seal.ljk.query.QLoan
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LoanDao {

    @SelectProvider(type = LoanProvider::class, method = "queryLoan")
    fun getLoanListByInvestNo(qLoan: QLoan): List<Loan>

    @SelectProvider(type = LoanProvider::class, method = "queryInvestLoan")
    fun queryInvestLoanByConditions(qLoan: QLoan): List<InvestLoan>


}