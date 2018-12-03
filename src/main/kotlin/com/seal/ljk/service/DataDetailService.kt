package com.seal.ljk.service

import com.seal.ljk.dao.DataDetailDao
import com.seal.ljk.model.*
import com.seal.ljk.query.QDataDetail
import com.seal.ljk.query.QDataDetailBusiness
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataDetailService {

    @Autowired
    lateinit var dataDetailDao: DataDetailDao

    fun queryLinkDetail(qDataDetail: QDataDetail): List<DataDetail> {
        return dataDetailDao.queryLinkDetail(qDataDetail)
    }

    fun queryDataDetailChannel(channelMarkName: String, toChainDate: String): List<DataDetailChannel> {
        val resultList = dataDetailDao.queryDataDetailChannel(channelMarkName, toChainDate)
        if (resultList.size > 0) {
            resultList.forEach {
                val dist = dataDetailDao.getDist("1", it.channelMark)
                it.channelMarkName = dist.name
            }
        }
        return resultList
    }

    fun queryToChainVid(secondHash: String): DataDetailLinkChain {
        val dataDetailToChain = dataDetailDao.queryToChainVid(secondHash)
        if(dataDetailToChain!=null){
            dataDetailToChain.linkLocalHash = dataDetailToChain.linkHash
        }
        return dataDetailToChain
    }

    fun queryDataDetailBusiness(qDataDetailBusiness: QDataDetailBusiness): List<DataDetailLocal> {
        return dataDetailDao.queryDataDetailBusiness(qDataDetailBusiness)
    }


    fun queryLjkAccountDetail(transactionId: String): List<LjkAccountDetail> {
        return dataDetailDao.queryLjkAccountDetail(transactionId)
    }

    fun queryLjkAttachment(transactionId: String): List<LjkAttachment> {
        return dataDetailDao.queryLjkAttachment(transactionId)
    }

    fun queryLjkCollection(transactionId: String): List<LjkCollection> {
        return dataDetailDao.queryLjkCollection(transactionId)
    }

    fun queryLjkCustomer(transactionId: String): List<LjkCustomer> {
        return dataDetailDao.queryLjkCustomer(transactionId)
    }

    fun queryLjkCustomerDetail(transactionId: String): List<LjkCustomerDetail> {
        return dataDetailDao.queryLjkCustomerDetail(transactionId)
    }

    fun queryLjkFinApply(transactionId: String): List<LjkFinApply> {
        return dataDetailDao.queryLjkFinApply(transactionId)
    }

    fun queryLjkIncomeStatistics(transactionId: String): List<LjkIncomeStatistics> {
        return dataDetailDao.queryLjkIncomeStatistics(transactionId)
    }

    fun queryLjkInvest(transactionId: String): List<LjkInvest> {
        return dataDetailDao.queryLjkInvest(transactionId)
    }

    fun queryLjkLoan(transactionId: String): List<LjkLoan> {
        return dataDetailDao.queryLjkLoan(transactionId)
    }

    fun queryLjkOperationalStatistics(transactionId: String): List<LjkOperationalStatistics> {
        return dataDetailDao.queryLjkOperationalStatistics(transactionId)
    }

    fun queryLjkOverdue(transactionId: String): List<LjkOverdue> {
        return dataDetailDao.queryLjkOverdue(transactionId)
    }

    fun queryLjkRepay(transactionId: String): List<LjkRepay> {
        return dataDetailDao.queryLjkRepay(transactionId)
    }

    fun queryLjkRisk(transactionId: String): List<LjkRisk> {
        return dataDetailDao.queryLjkRisk(transactionId)
    }

    fun queryLjkRiskDetail(transactionId: String): List<LjkRiskDetail> {
        return dataDetailDao.queryLjkRiskDetail(transactionId)
    }

    fun queryLjkStatusChange(transactionId: String): List<LjkStatusChange> {
        return dataDetailDao.queryLjkStatusChange(transactionId)
    }

}