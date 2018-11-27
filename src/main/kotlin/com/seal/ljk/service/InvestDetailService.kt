package com.seal.ljk.service

import com.seal.ljk.dao.InvestDao
import com.seal.ljk.dao.InvestDetailDao
import com.seal.ljk.model.InvestDetail
import com.seal.ljk.model.InvestDetailList
import com.seal.ljk.query.QInvestDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InvestDetailService {

    @Autowired
    lateinit var investDetailDao: InvestDetailDao
    @Autowired
    lateinit var investDao: InvestDao


    /*投资已还款列表查询*/
    fun getRepaymentList(investorWalletAddr: String,currentPage: Int, pageSize: Int):InvestDetailList {
        var resulList= InvestDetailList()
        //投资总金额和已收总利息
        val invest = investDao.getPartnerById(investorWalletAddr)
        resulList.totalInvestAmt = invest.totalInvestAmt
        resulList.earnedAmt = invest.earnedAmt
        //已还款列表查询
        resulList.list = investDetailDao.getRepaymentList(investorWalletAddr,currentPage, pageSize)

        return resulList
    }

    /***
     * 授权投资明细查询
     */
    fun queryAuthorizeInvestDetail(qInvestDetail: QInvestDetail): List<InvestDetail>{
        return investDetailDao.queryAuthorizeInvestDetail(qInvestDetail)
    }

    /*已投资未回款列表*/
    fun getNonReturnList(investorWalletAddr: String,currentPage: Int, pageSize: Int):List<InvestDetail> {
        return investDetailDao.getNonReturnList(investorWalletAddr,currentPage, pageSize)
    }
}