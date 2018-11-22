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
open class InvestService {

    @Autowired
    lateinit var investDao: InvestDao

    @Autowired
    lateinit var investDetailDao: InvestDetailDao

    @Autowired
    lateinit var loanDao: LoanDao

    @Autowired
    lateinit var loanDetailDao: LoanDetailDao

    @Autowired
    lateinit var transDetailDao: TransDetailDao

    @Autowired
    lateinit var partnerProductDao: PartnerProductDao

    /*投资收益统计数据查询*/
    fun getPartnerById(investorWalletAddr: String): Invest {
        return investDao.getPartnerById(investorWalletAddr)
    }

    /***
     * 我要投资
     * data: 合作方钱包地址/合作方ID/合作方产品ID/投资人钱包地址/投资金额
     */
    @Transactional
    open fun saveWantInvest(data: Map<String, Any>) {

        // 调用主链接口
        // this.doWalletApi()

        // 生成投资明细表
        val investDetail = this.buildInvestDetail(data)
        investDetailDao.createInvestDetail(investDetail)

        // 生成投资汇总表
        val invest = this.buildInvest(investDetail)
        investDao.createInvest(invest)

        // 生成投资-交易明细
        val investTransDetail = this.buildTransDetail(investDetail, Constant.TRANS_TYPE.INVEST)
        transDetailDao.createTransDetail(investTransDetail)

        // 生成借款明细表
        val loanDetail = this.buildLoanDetail(investDetail)
        loanDetailDao.createLoanDetail(loanDetail)

        // 生成借款汇总表
        val loan = this.buildLoan(loanDetail)
        loanDao.createLoan(loan)

        // 生成借款-交易明细
        val loanTransDetail = this.buildTransDetail(loanDetail, Constant.TRANS_TYPE.LOAN)
        transDetailDao.createTransDetail(loanTransDetail)

    }

    private fun doWalletApi() {
        val data = mapOf<String, Any>()
        val request = HttpUtil.postRequest("", data)
        val result = HttpUtil.sendRequest(request)
    }

    private fun buildInvestDetail(data: Map<String, Any>): InvestDetail {

        val partnerWalletAddr = data["partnerWalletAddr"].toString()
        val partnerId = data["partnerId"].toString()
        val productId = data["productId"].toString()
        val investAmt = data["investAmt"].toString()
        val investPeriod = data["investPeriod"].toString()
        val investorWalletAddr = data["investorWalletAddr"].toString()

        val investDetail = InvestDetail()
        // 根据规则生成
        investDetail.investDetailId = UUID.randomUUID().toString().substring(0, 20)
        investDetail.investId = UUID.randomUUID().toString().substring(0, 20)
        investDetail.chainTransNo = UUID.randomUUID().toString().substring(0, 20)

        // 获取当前用户信息作为投资人数据
        investDetail.investAmt = BigDecimal(investAmt)
        investDetail.investorWalletAddr = investorWalletAddr

        // 根据ID获取投资的产品
        val product = partnerProductDao.getPartnerProductById(productId)
        investDetail.investPeriod = investPeriod.toInt()
        investDetail.dayRate = product.dayRate
        investDetail.investDate = Date()
        investDetail.expireDate = product.endDate

        // 计算金额
        investDetail.preRcvPrincipal = investDetail.investAmt
        investDetail.preIncome = investDetail.preRcvPrincipal.multiply(investDetail.dayRate).multiply(BigDecimal(investDetail.investPeriod))
        investDetail.preRcvAmt = investDetail.preRcvPrincipal.add(investDetail.preIncome)

        // 合作方信息
        investDetail.partnerId = partnerId
        investDetail.partnerWalletAddr = partnerWalletAddr

        // 默认初始状态
        investDetail.status = Constant.INVEST_STATUS.BACKING

        return investDetail
    }

    private fun buildInvest(investDetail: InvestDetail): Invest {
        val invest = Invest()
        invest.investId = investDetail.investId
        invest.investorWalletAddr = investDetail.investorWalletAddr
        invest.totalPendingAmt = investDetail.preRcvAmt
        invest.totalInvestAmt = investDetail.investAmt
        invest.unearnedAmt = investDetail.preIncome
        return invest
    }

    private fun buildLoanDetail(investDetail: InvestDetail): LoanDetail {
        val loanDetail = LoanDetail()
        loanDetail.loanDetailId = UUID.randomUUID().toString().substring(0, 20)
        loanDetail.partnerId = investDetail.partnerId
        loanDetail.partnerWalletAddr = investDetail.partnerWalletAddr
        loanDetail.loanId = UUID.randomUUID().toString().substring(0, 20)
        loanDetail.chainTransNo = UUID.randomUUID().toString().substring(0, 20)
        loanDetail.investorWalletAddr = investDetail.investorWalletAddr
        loanDetail.investId = investDetail.investId
        loanDetail.duePrinpal = investDetail.preRcvPrincipal
        loanDetail.dueInterest = investDetail.preIncome
        loanDetail.dueAmt = investDetail.preRcvAmt
        loanDetail.dueDate = investDetail.investDate
        loanDetail.loanPeriod = investDetail.investPeriod
        loanDetail.dayRate = investDetail.dayRate
        // 默认初始状态
        loanDetail.status = Constant.LOAN_STATUS.PAYING
        loanDetail.investDate = investDetail.investDate
        return loanDetail
    }

    private fun buildLoan(loanDetail: LoanDetail): Loan {
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
            transDetail.transDetailId = UUID.randomUUID().toString().substring(0, 20)
            transDetail.transDate = data.investDate
            transDetail.walletAddr = data.partnerWalletAddr + "TO" + data.investorWalletAddr
            transDetail.transType = transType
            transDetail.platformTransNo = data.chainTransNo
            transDetail.chainTransNo = data.chainTransNo
            transDetail.transAmt = data.actualPayAmt
        } else if (Constant.TRANS_TYPE.INVEST == transType && data is InvestDetail) {
            transDetail.transDetailId = UUID.randomUUID().toString().substring(0, 20)
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