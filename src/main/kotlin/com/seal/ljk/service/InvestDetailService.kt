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

    /***
     * 授权投资明细查询
     */
    fun queryAuthorizeInvestDetail(qInvestDetail: QInvestDetail): List<InvestDetail> {
        return investDetailDao.queryAuthorizeInvestDetail(qInvestDetail)
    }

    /***
     * 投资列表
     */
    fun getInvestDetailByUser(userNo: String): List<InvestDetail> {
        return investDetailDao.getInvestDetailByUser(userNo)
    }

    /*已投资未回款列表*/
    fun getNonReturnList(investorWalletAddr: String,currentPage: Int, pageSize: Int):List<InvestDetail> {
        return investDetailDao.getNonReturnList(investorWalletAddr,currentPage, pageSize)
    }

    fun getInvestDetailByInvestNo(investNo: String): InvestDetail {
        return investDetailDao.getInvestDetailByInvestNo(investNo)
    }

    fun updateInvestDetailById(investDetail: InvestDetail) {
        investDetailDao.updateInvestDetailById(investDetail)
    }
}