package com.seal.ljk.dao

import com.seal.ljk.model.InvestLoan
import com.seal.ljk.model.Loan
import com.seal.ljk.provider.LoanProvider
import com.seal.ljk.query.QLoan
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LoanDao {

    @SelectProvider(type = LoanProvider::class, method = "getLoanListByInvestNo")
    fun getLoanListByInvestNo(qLoan: QLoan): List<Loan>

    @SelectProvider(type = LoanProvider::class, method = "queryInvestLoanByConditions")
    fun queryInvestLoanByConditions(qLoan: QLoan): List<InvestLoan>


}