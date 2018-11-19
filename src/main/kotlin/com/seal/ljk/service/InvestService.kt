package com.seal.ljk.service

import com.seal.ljk.dao.InvestDao
import com.seal.ljk.dao.InvestDetailDao
import com.seal.ljk.model.Invest
import com.seal.ljk.model.InvestDetail
import com.seal.ljk.model.InvestDetailList
import com.seal.ljk.query.QInvestDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InvestService {

    @Autowired
    lateinit var investDao: InvestDao

    /*投资收益统计数据查询*/
    fun getPartnerById(investorWalletAddr: String): Invest {
        return investDao.getPartnerById(investorWalletAddr)
    }

}