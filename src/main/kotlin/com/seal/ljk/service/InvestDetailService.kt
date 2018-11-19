package com.seal.ljk.service

import com.seal.ljk.dao.InvestDetailDao
import com.seal.ljk.model.InvestDetail
import com.seal.ljk.query.QInvestDetail
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

    /***
     * 投资明细查询
     */
    fun queryWalletInvestDetail(qInvestDetail: QInvestDetail): List<InvestDetail>{
        return investDetailDao.queryWalletInvestDetail(qInvestDetail)
    }

    /***
     * 投资人回款明细查询
     */
    fun queryPaybackInvestDetail(qInvestDetail: QInvestDetail): List<InvestDetail>{
        return investDetailDao.queryPaybackInvestDetail(qInvestDetail)
    }

    /*已投资未回款列表*/
    fun getNonReturnList(investorWalletAddr: String,currentPage: Int, pageSize: Int):List<InvestDetail> {
        return investDetailDao.getNonReturnList(investorWalletAddr,currentPage, pageSize)
    }
}