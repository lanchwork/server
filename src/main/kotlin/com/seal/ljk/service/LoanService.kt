package com.seal.ljk.service

import com.seal.ljk.dao.*
import com.seal.ljk.model.*
import com.seal.ljk.query.QLoan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class LoanService {

    @Autowired
    lateinit var loanDao: LoanDao

    fun getLoanListByInvestNo(qLoan: QLoan): List<Loan> {
        return loanDao.getLoanListByInvestNo(qLoan)
    }


}