package com.seal.ljk.service

import com.seal.ljk.dao.LoanDao
import com.seal.ljk.dao.PartnerDao
import com.seal.ljk.model.Loan
import com.seal.ljk.model.Partner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoanService {


    @Autowired
    lateinit var loanDao: LoanDao

    /*借款利息支付统计查询*/
    fun getPartnerById(loanerWalletAddr: String): Loan {
        return loanDao.getPartnerById(loanerWalletAddr)
    }
}