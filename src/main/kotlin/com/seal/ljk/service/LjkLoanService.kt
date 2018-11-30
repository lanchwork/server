package com.seal.ljk.service

import com.seal.ljk.dao.LjkLoanDao
import com.seal.ljk.model.LjkLoan
import com.seal.ljk.query.QLjkLoan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LjkLoanService {

    @Autowired
    lateinit var ljkLoanDao: LjkLoanDao

    fun queryLjkLoanByConditions(qLjkLoan: QLjkLoan): List<LjkLoan> {
        return ljkLoanDao.queryByConditions(qLjkLoan)
    }
}
