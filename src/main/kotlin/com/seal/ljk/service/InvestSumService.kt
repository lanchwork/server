package com.seal.ljk.service

import com.seal.ljk.common.Constant
import com.seal.ljk.common.HttpUtil
import com.seal.ljk.dao.*
import com.seal.ljk.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.util.*

@Service
open class InvestSumService {

    @Autowired
    lateinit var investSumDao: InvestSumDao

    @Autowired
    lateinit var investDetailDao: InvestDetailDao

    /***
     * 收益统计数据
     */
    fun getInvestSumByUser(userNo: String): InvestSum {
        return investSumDao.getInvestSumByUser(userNo)!!
    }

    /***
     * 我要投资
     * data: 合作方钱包地址/合作方ID/投资金额
     */
    @Transactional
    open fun saveWantInvest(data: Map<String, Any>) {

        // 调用主链接口
        // this.doWalletApi()

        // 生成投资明细表
        val investDetail = this.buildInvestDetail(data)
        investDetailDao.createInvestDetail(investDetail)

        // 生成投资汇总表
        this.saveOrUpdateInvestSum(investDetail)

    }

    private fun doWalletApi() {
        val data = mapOf<String, Any>()
        val request = HttpUtil.postRequest("", data)
        val result = HttpUtil.sendRequest(request)
    }

    private fun buildInvestDetail(data: Map<String, Any>): InvestDetail {

        // 界面输入
        val partnerWalletAddr = data["partnerWalletAddr"].toString()
        val investAmt = data["investAmt"].toString()
        // 从首页选择的合作方中带过来？
        val partnerId = data["partnerId"].toString()
        val investPeriod = data["investPeriod"].toString()
        val expectDayRate = data["expectDayRate"].toString()
        // 从当前session中获取？
        val investorWalletAddr = data["investorWalletAddr"].toString()
        val userNo = data["userNo"].toString()

        val investDetail = InvestDetail()
        // 根据规则生成
        investDetail.investDetailId = UUID.randomUUID().toString().substring(0, 20)
        investDetail.investNo = UUID.randomUUID().toString().substring(0, 20)
        investDetail.chainTransNo = UUID.randomUUID().toString().substring(0, 20)

        investDetail.investAmt = BigDecimal(investAmt)
        investDetail.unsettledPrincipal = BigDecimal(investAmt)
        investDetail.investorWalletAddr = investorWalletAddr
        investDetail.userNo = userNo
        investDetail.investPeriod = investPeriod.toInt()
        investDetail.expectDayRate = BigDecimal(expectDayRate)
        investDetail.investDate = Date()
        investDetail.partnerId = partnerId
        investDetail.partnerWalletAddr = partnerWalletAddr

        // 默认初始状态
        investDetail.status = Constant.INVEST_STATUS.BACKING

        return investDetail
    }

    private fun saveOrUpdateInvestSum(investDetail: InvestDetail): InvestSum {
        // 判断该用户是否已经存在投资汇总表
        var investSum = investSumDao.getInvestSumByUser(investDetail.userNo)
        investSum = investSum ?: InvestSum()

        // 计算金额(累加)
        val detailEarnedAmt = investDetail.investAmt.multiply(investDetail.expectDayRate).multiply(BigDecimal(investDetail.investPeriod))
        investSum.totalInvestAmt = investSum.totalInvestAmt.add(investDetail.investAmt)
        investSum.earnedAmt
        investSum.unearnedAmt = investSum.unearnedAmt.add(detailEarnedAmt)
        investSum.totalPendingAmt = investSum.totalPendingAmt.add(investSum.totalInvestAmt.add(investSum.earnedAmt).add(investSum.unearnedAmt))

        if (investSum.investSumId.isEmpty()){
            investSum.investSumId = UUID.randomUUID().toString().substring(0, 20)
            investSum.userNo = investDetail.userNo
            investSumDao.createInvestSum(investSum)
        } else {
            investSumDao.updateInvestSumById(investSum)
        }
        return investSum
    }
}