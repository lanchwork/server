package com.seal.ljk.service

import com.seal.ljk.dao.InvestDetailDao
import com.seal.ljk.model.InvestDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InvestDetailService {

    @Autowired
    lateinit var investDetailDao: InvestDetailDao

    /*投资已还款列表查询*/
    fun getRepaymentList(investorWalletAddr: String,currentPage: Int, pageSize: Int):List<InvestDetail> {
        return investDetailDao.getRepaymentList(investorWalletAddr,currentPage, pageSize)
    }
}