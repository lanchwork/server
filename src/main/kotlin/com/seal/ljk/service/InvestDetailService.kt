package com.seal.ljk.service

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

    /*投资已还款列表查询*/
    fun getRepaymentList(investorWalletAddr: String,currentPage: Int, pageSize: Int):InvestDetailList {
        var resulList= InvestDetailList()
        //统计出投资总金额和已收总利息
        resulList.actualRcvPrincipalSum = investDetailDao.getActualRcvPrincipalSum(investorWalletAddr)
        resulList.actualRcvInterestSum  = investDetailDao.getActualRcvInterestSum(investorWalletAddr)
        //已还款列表查询
        resulList.list = investDetailDao.getRepaymentList(investorWalletAddr,currentPage, pageSize)

        return resulList
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
}