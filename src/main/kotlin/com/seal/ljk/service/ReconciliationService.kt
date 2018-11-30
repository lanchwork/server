package com.seal.ljk.service

import com.seal.ljk.dao.ReconciliationDao
import com.seal.ljk.model.Reconciliation
import com.seal.ljk.query.QReconciliation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class ReconciliationService {
    @Autowired
    lateinit var reconciliationDao: ReconciliationDao

    @Autowired
    lateinit var partnerService: PartnerService

    fun getAllReconciliation(): List<Reconciliation> {
        return reconciliationDao.getAllReconciliation()
    }

    fun getReconciliationById(partnerId: String): Reconciliation {
        return reconciliationDao.getReconciliationById(partnerId)
    }

    fun getReconciliationList(currentPage: Int, pageSize: Int): List<Reconciliation> {
        return reconciliationDao.getReconciliationList(currentPage, pageSize)
    }

    fun getReconciliationByCondition(qReconciliation: QReconciliation): List<Reconciliation> {
        return reconciliationDao.getReconciliationByCondition(qReconciliation)
    }

    /**
     * @Description: 对账数据的统计方法
     * @Author: tingyx
     * @Time: 2018-11-28 11:12
     */
    fun calculateReconciliation(){
        val allPartners = partnerService.getAllPartner()
        //每天对每一个合作方进行一次统计
        allPartners.forEach {
            //对账主键ID
            val reconciliationId = UUID.randomUUID().toString().substring(0, 20)
            //合作方ID
            val partnerId = it.partnerId
            //统计日期
            val statisticsDate = Date()

            val rcvMap = reconciliationDao.sumInvestAmtByPartnerId(partnerId)
            //收款金额
            val rcvAmt = if(rcvMap != null)
                rcvMap["rcv_amt"] ?: BigDecimal.ZERO
            else
                BigDecimal.ZERO

            val loanMap = reconciliationDao.sumLoanAmtByPartnerId(partnerId)
            //放款金额
            val loanAmt = if(loanMap != null)
                loanMap["loan_amt"] ?: BigDecimal.ZERO
            else
                BigDecimal.ZERO

            val settledMap = reconciliationDao.sumSettlementByPartnerId(partnerId)
            //结算金额
            val settleAmt = if(settledMap != null)
                settledMap["settle_amt"] ?: BigDecimal.ZERO
            else
                BigDecimal.ZERO
            //投资人总分润
            val investorTotalProfit = if(settledMap != null)
                settledMap["investor_total_profit"] ?: BigDecimal.ZERO
            else
                BigDecimal.ZERO
            //seal总分润
            val sealTotalProfit = if(settledMap != null)
                settledMap["seal_total_profit"] ?: BigDecimal.ZERO
            else
                BigDecimal.ZERO

            //计算待结算余额=上一次结算时还在款中的金额(已存储在投资明细表的未结算本金字段)+上一次结算后还款的利润
            val unsettledMap = reconciliationDao.sumUnsettledPrincipalByPartnerId(partnerId)
            val profitMap = reconciliationDao.sumProfitByPartnerId(partnerId)
            //未结算本金
            val unsettledPrincipal = if(unsettledMap != null)
                unsettledMap["unsettled_principal"] ?: BigDecimal.ZERO
            else
                BigDecimal.ZERO
            //自上次结算后还款的利润
            val investorProfit =  if(unsettledMap != null)
                profitMap["investor_profit"] ?: BigDecimal.ZERO
            else
                BigDecimal.ZERO
            //待结算余额
            val balance = unsettledPrincipal + investorProfit

            val reconciliation = Reconciliation(reconciliationId, partnerId, "", statisticsDate, rcvAmt, loanAmt, settleAmt,
                    balance, investorTotalProfit, sealTotalProfit, "","")

            println(reconciliation.toString())

            reconciliationDao.create(reconciliation)

        }
    }
}