package com.seal.ljk.service

import com.seal.ljk.Query.QloanDetail
import com.seal.ljk.dao.LoanDetailDao
import com.seal.ljk.model.LoanDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoanDetailService {

    @Autowired
    lateinit var loanDetailDao: LoanDetailDao

//    fun query(qLoanDetail: QloanDetail): List<LoanDetail>{
//        return loanDetailDao.queryByProvider(qLoanDetail)
//    }

    /**
     * 我的借款已还款列表
     */
    fun getRepaymentList(partnerWalletAddr: String,currentPage: Int, pageSize: Int):List<LoanDetail>{

        return loanDetailDao.getRepaymentList(partnerWalletAddr,currentPage,pageSize)
    }

}