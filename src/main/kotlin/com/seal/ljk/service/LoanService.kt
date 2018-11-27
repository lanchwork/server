package com.seal.ljk.service

import com.seal.ljk.dao.*
import com.seal.ljk.model.*
import com.seal.ljk.query.QLoan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoanService {

    @Autowired
    lateinit var loanDao: LoanDao

    fun getLoanListByInvestNo(qLoan: QLoan): LoanList {
        val resultList = LoanList()
        resultList.list = loanDao.getLoanListByInvestNo(qLoan)
        //可结算金额settleableAmt=

        //已结算金额settledAmt=

        //未结算金额unsettledAmt=

        return resultList
    }

    fun queryInvestLoanByInvestNo(qLoan: QLoan): List<InvestLoan> {
        return loanDao.queryInvestLoanByInvestNo(qLoan)
    }


}