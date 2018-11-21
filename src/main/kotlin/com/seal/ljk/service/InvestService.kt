package com.seal.ljk.service

import com.seal.ljk.common.Constant
import com.seal.ljk.common.HttpUtil
import com.seal.ljk.dao.InvestDao
import com.seal.ljk.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
open class InvestService {

    @Autowired
    lateinit var investDao: InvestDao

    /*投资收益统计数据查询*/
    fun getPartnerById(investorWalletAddr: String): Invest {
        return investDao.getPartnerById(investorWalletAddr)
    }

    /***
     * 我要投资
     */
    @Transactional
    open fun saveWantInvest(data: Map<String, Any>) {

        // data包括合作方的钱包地址和合作方产品ID和投资金额

        // 调用主链接口
        this.doWalletApi()

        // 生成投资明细表
        val investDetail = this.buildInvestDetail(data)

        // 生成投资汇总表
        val invest = this.buildInvest(data, investDetail)

        // 生成投资-交易明细
        val investTransDetail = this.buildTransDetail(investDetail, Constant.TRANS_TYPE.INVEST)

        // 生成借款明细表
        val loanDetail = this.buildLoanDetail(data, investDetail)

        // 生成借款汇总表
        val loan = this.buildLoan(data, loanDetail)

        // 生成借款-交易明细
        val loanTransDetail = this.buildTransDetail(loanDetail, Constant.TRANS_TYPE.LOAN)

    }

    private fun doWalletApi() {
        val data = mapOf<String, Any>()
        val request = HttpUtil.postRequest("", data)
        val result = HttpUtil.sendRequest(request)
    }

    private fun buildInvestDetail(data: Map<String, Any>): InvestDetail {

        val partnerWalletAddr = data.get("partnerWalletAddr")
        val productId = data.get("productId")
        val investAmt = data.get("investAmt")


        val investDetail = InvestDetail()
        // 根据规则生成
        investDetail.investDetailId = UUID.randomUUID().toString()
        investDetail.investId = UUID.randomUUID().toString()
        investDetail.chainTransNo = UUID.randomUUID().toString()

        // 获取当前用户信息作为投资人数据
        investDetail.investAmt
        investDetail.investorWalletAddr

        // 根据ID获取投资的产品
        val product = PartnerProduct()
        investDetail.investPeriod = product.endDate.toInt()
        investDetail.dayRate
        investDetail.investDate = Date()
        investDetail.expireDate = Date(product.endDate)

        // 计算金额
        investDetail.preRcvPrincipal = investDetail.investAmt
        investDetail.preIncome
        investDetail.preRcvAmt = investDetail.preRcvPrincipal.add(investDetail.preIncome)

        // 合作方信息
        investDetail.partnerId
        investDetail.partnerWalletAddr = partnerWalletAddr.toString()

        // 默认初始状态
        investDetail.status


        return investDetail
    }

    private fun buildInvest(data: Map<String, Any>, investDetail: InvestDetail): Invest {
        val invest = Invest()
        invest.investId = investDetail.investId
        invest.investorWalletAddr = investDetail.investorWalletAddr
        invest.totalPendingAmt = investDetail.preRcvAmt
        invest.totalInvestAmt = investDetail.investAmt
        invest.unearnedAmt = investDetail.preIncome
        return invest
    }

    private fun buildLoanDetail(data: Map<String, Any>, investDetail: InvestDetail): LoanDetail {
        val loanDetail = LoanDetail()
        loanDetail.loanDetailId = UUID.randomUUID().toString()
        loanDetail.partnerId = investDetail.partnerId
        loanDetail.partnerWalletAddr = investDetail.partnerWalletAddr
        loanDetail.loanId = UUID.randomUUID().toString()
        loanDetail.chainTransNo = UUID.randomUUID().toString()
        loanDetail.investorWalletAddr = investDetail.investorWalletAddr
        loanDetail.investId = investDetail.investId
        loanDetail.duePrinpal = investDetail.preRcvPrincipal
        loanDetail.dueInterest = investDetail.preIncome
        loanDetail.dueAmt = investDetail.preRcvAmt
        loanDetail.dueDate = investDetail.investDate
        loanDetail.loanPeriod = investDetail.investPeriod
        loanDetail.dayRate = investDetail.dayRate
        // 默认初始状态
        loanDetail.status
        loanDetail.investDate = investDetail.investDate
        return loanDetail
    }

    private fun buildLoan(data: Map<String, Any>, loanDetail: LoanDetail): Loan {
        val loan = Loan()
        loan.loanId = loanDetail.loanId
        loan.loanerWalletAddr = loanDetail.investorWalletAddr
        loan.totalRepayAmt = loanDetail.dueAmt
        loan.totalLoanAmt = loanDetail.actualPayAmt
        loan.unpayInterest = loanDetail.dueInterest
        return loan
    }

    private fun buildTransDetail(data: Any, transType: String): TransDetail {
        val transDetail = TransDetail()
        if (Constant.TRANS_TYPE.LOAN == transType && data is LoanDetail) {
            transDetail.transDetailId = UUID.randomUUID().toString()
            transDetail.transDate = data.investDate
            transDetail.walletAddr = data.partnerWalletAddr + "TO" + data.investorWalletAddr
            transDetail.transType = transType
            transDetail.platformTransNo = data.chainTransNo
            transDetail.chainTransNo = data.chainTransNo
            transDetail.transAmt = data.actualPayAmt
        } else if (Constant.TRANS_TYPE.INVEST == transType && data is InvestDetail) {
            transDetail.transDetailId = UUID.randomUUID().toString()
            transDetail.transDate = data.investDate
            transDetail.walletAddr = data.investorWalletAddr + "TO" + data.partnerWalletAddr
            transDetail.transType = transType
            transDetail.platformTransNo = data.chainTransNo
            transDetail.chainTransNo = data.chainTransNo
            transDetail.transAmt = data.investAmt
        }
        return transDetail
    }
}