package com.seal.ljk.service

import com.seal.ljk.Query.QLoanDetail
import com.seal.ljk.dao.LoanDetailDao
import com.seal.ljk.model.LoanDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoanDetailService {

    @Autowired
    lateinit var loanDetailDao: LoanDetailDao

    fun query(qLoanDetail: QLoanDetail): List<LoanDetail>{
        return loanDetailDao.queryByProvider(qLoanDetail)
    }

    /**
     * 我的借款已还款列表
     */
    fun getRepaymentList(partnerWalletAddr: String,currentPage: Int, pageSize: Int):List<LoanDetail>{

        return loanDetailDao.getRepaymentList(partnerWalletAddr,currentPage,pageSize)
    }
    /**
     * 我的借款未还款列表
     */
    fun getNotRepayList(partnerId : String):List<LoanDetail>{
        return loanDetailDao.getNotRepayList(partnerId)
    }
}