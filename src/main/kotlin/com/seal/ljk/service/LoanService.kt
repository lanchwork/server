package com.seal.ljk.service

import com.seal.ljk.common.Constant
import com.seal.ljk.common.HttpUtil
import com.seal.ljk.dao.*
import com.seal.ljk.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
open class LoanService {

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

    /*借款利息支付统计查询*/
    fun getPartnerById(loanerWalletAddr: String): Loan {
        return loanDao.getPartnerById(loanerWalletAddr)
    }

    /***
     * 我要还款
     * data: 借款明细ID/还款金额
     */
    @Transactional
    open fun saveWantRepay(data: Map<String, Any>) {

        // 调用主链接口
        // this.doWalletApi()

        // 更新借款明细表
        val loanDetail = this.buildLoanDetail(data)
        loanDetailDao.updateLoanDetailById(loanDetail)

        // 更新借款汇总表
        val loan = this.buildLoan(loanDetail)
        loanDao.updateLoanById(loan)

        // 生成还款-交易明细
        val loanTransDetail = this.buildTransDetail(loanDetail, Constant.TRANS_TYPE.REPAY)
        transDetailDao.createTransDetail(loanTransDetail)

        // 更新投资明细表
        val investDetail = this.buildInvestDetail(loanDetail)
        investDetailDao.updateInvestDetailById(investDetail)

        // 更新投资汇总表
        val invest = this.buildInvest(investDetail)
        investDao.updateInvestById(invest)

        // 生成回款-交易明细
        val investTransDetail = this.buildTransDetail(investDetail, Constant.TRANS_TYPE.PAYBACK)
        transDetailDao.createTransDetail(investTransDetail)

    }

    private fun doWalletApi() {
        val data = mapOf<String, Any>()
        val request = HttpUtil.postRequest("", data)
        val result = HttpUtil.sendRequest(request)
    }

    private fun buildLoanDetail(data: Map<String, Any>): LoanDetail {

        val loanDetailId = data["loanDetailId"].toString()
        val payAmt = data["payAmt"].toString()

        // 查出对应的借款明细
        val loanDetail = loanDetailDao.getLoanDetailById(loanDetailId)

        // 判断是否逾期？

        // 计算金额
        loanDetail.actualPayPrincipal
        loanDetail.actualPayInterest
        loanDetail.actualPayAmt
        loanDetail.actualPayDate

        // 更新状态
        loanDetail.status

        return loanDetail
    }

    private fun buildLoan(loanDetail: LoanDetail): Loan {
        val loan = loanDao.getLoanById(loanDetail.loanId)

        loan.totalRepayAmt = loanDetail.dueAmt
        loan.totalLoanAmt = loanDetail.actualPayAmt
        loan.payInterest
        loan.unpayInterest = loanDetail.dueInterest
        loan.totalPayAmt

        return loan
    }

    private fun buildInvestDetail(loanDetail: LoanDetail): InvestDetail {

        // 根据借款明细查询出投资明细
        val investDetail = investDetailDao.getInvestDetailByInvestId(loanDetail.investId)

        // 判断是否逾期？

        // 计算金额
        investDetail.actualRcvPrincipal
        investDetail.actualRcvInterest
        investDetail.actualRcvAmt
        investDetail.actualRcvDate

        // 更新状态
        investDetail.status

        return investDetail
    }

    private fun buildInvest(investDetail: InvestDetail): Invest {
        val invest = investDao.getInvestById(investDetail.investId)
        invest.investId = investDetail.investId
        invest.investorWalletAddr = investDetail.investorWalletAddr
        invest.totalPendingAmt = investDetail.preRcvAmt
        invest.totalInvestAmt = investDetail.investAmt
        invest.unearnedAmt = investDetail.preIncome
        return invest
    }

    private fun buildTransDetail(data: Any, transType: String): TransDetail {
        val transDetail = TransDetail()
        transDetail.transDetailId = UUID.randomUUID().toString().substring(0, 20)
        if (Constant.TRANS_TYPE.LOAN == transType && data is LoanDetail) {
            transDetail.transDate = data.investDate
            transDetail.walletAddr = data.partnerWalletAddr + "TO" + data.investorWalletAddr
            transDetail.transType = transType
            transDetail.platformTransNo = data.chainTransNo
            transDetail.chainTransNo = data.chainTransNo
            transDetail.transAmt = data.actualPayAmt
        } else if (Constant.TRANS_TYPE.INVEST == transType && data is InvestDetail) {
            transDetail.transDate = data.investDate
            transDetail.walletAddr = data.investorWalletAddr + "TO" + data.partnerWalletAddr
            transDetail.transType = transType
            transDetail.platformTransNo = data.chainTransNo
            transDetail.chainTransNo = data.chainTransNo
            transDetail.transAmt = data.investAmt
        } else if (Constant.TRANS_TYPE.REPAY == transType && data is LoanDetail) {
            transDetail.transDate = data.investDate
            transDetail.walletAddr = data.partnerWalletAddr + "TO" + data.investorWalletAddr
            transDetail.transType = transType
            transDetail.platformTransNo = data.chainTransNo
            transDetail.chainTransNo = data.chainTransNo
            transDetail.transAmt = data.actualPayAmt
        } else if (Constant.TRANS_TYPE.PAYBACK == transType && data is InvestDetail) {
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