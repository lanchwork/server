package com.seal.ljk.service

import com.seal.ljk.common.Constant
import com.seal.ljk.common.HttpUtil
import com.seal.ljk.dao.LoanDao
import com.seal.ljk.dao.SettlementDao
import com.seal.ljk.dao.SettlementSumDao
import com.seal.ljk.model.InvestDetail
import com.seal.ljk.model.InvestSettlement
import com.seal.ljk.model.Settlement
import com.seal.ljk.model.SettlementSum
import com.seal.ljk.query.QSettlement
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException
import java.math.BigDecimal
import java.util.*

@Service
class SettlementService {

    @Autowired
    lateinit var settlementDao: SettlementDao

    @Autowired
    lateinit var settlementSumDao: SettlementSumDao

    @Autowired
    lateinit var partnerService: PartnerService

    @Autowired
    lateinit var investDetailService: InvestDetailService

    @Autowired
    lateinit var loanDao: LoanDao

    fun getSettlementListByUserNo(qSettlement: QSettlement): List<Settlement> {
        return settlementDao.getSettlementListByUserNo(qSettlement)
    }

    /***
     * 申请结算
     */
    @Transactional
    fun saveApplySettlement(data: Map<String, Any>) {
        // 生成结算
        val settlement = this.buildSettlement4Apply(data)
        settlementDao.createSettlement(settlement)

        // 生成结算汇总
        this.saveOrUpdateSettlementSum(settlement)
    }

    /***
     * 结算
     */
    @Transactional
    fun saveWantSettlement(data: Map<String, Any>) {

        // 调用主链接口
        // val signedTx = data["signedTx"].toString()
        // this.doWalletApi(signedTx)

        // 更新结算表
        val settlement = this.buildSettlement4Settle(data)
        settlementDao.updateSettlementById(settlement)

        // 更新结算汇总
        this.saveOrUpdateSettlementSum(settlement)

        // 更新投资表
        val investDetail = this.buildInvestDetail(settlement)
        investDetailService.updateInvestDetailById(investDetail)
    }

    private fun doWalletApi(signedTx: String) {
        val data = mutableMapOf<String, Any>()
        data["signedTx"] = signedTx
        val request = HttpUtil.postRequest(Constant.IMPORTER_URL, data)
        val response = HttpUtil.getRawResponse(request)
        if (!response.isSuccessful) {
            throw RuntimeException("======== TRANS ERROR! ========")
        }
    }

    private fun buildSettlement4Apply(data: Map<String, Any>): Settlement {
        // 从待结算明细页面带过来
        val investorWalletAddr = data["investorWalletAddr"].toString()
        val settlementAmt = data["settlementAmt"].toString()
        val sealWalletAddr = data["sealWalletAddr"].toString()
        val partnerWalletAddr = data["partnerWalletAddr"].toString()
        val partnerId = data["partnerId"].toString()
        val investNo = data["investNo"].toString()
        val settlePrincipal = data["settlePrincipal"].toString()

        val settlement = Settlement()
        settlement.settlementId = UUID.randomUUID().toString().substring(0, 20)
        settlement.userNo = this.getPartnerUserNo(partnerId)
        settlement.investNo = investNo
        settlement.applySettleAmt = BigDecimal(settlementAmt)
        settlement.applyTime = Date()
        settlement.settlePrincipal = BigDecimal(settlePrincipal)
        // 分润是在新增放款表数据的时候生成的
        val profitMap = loanDao.getProfit(investNo)
        // 投资人分润=实际放款利息*（1-合作方分润比例）*投资人分润比例
        settlement.investorProfit = profitMap["investorProfit"]!!
        // Seal分润=实际放款利息*（1-合作方分润比例）*Seal分润比例
        settlement.sealProfit = profitMap["sealProfit"]!!
        settlement.status = Constant.SETTLE_STATUS.APPLY
        settlement.settleTime
        settlement.chainTransNo
        settlement.investorWalletAddr = investorWalletAddr
        settlement.partnerWalletAddr = partnerWalletAddr
        settlement.sealWalletAddr = sealWalletAddr

        return settlement
    }

    private fun getPartnerUserNo(partnerId: String): String {
        val partner = partnerService.getPartnerById(partnerId)
        return partner.userNo
    }

    private fun buildSettlement4Settle(data: Map<String, Any>): Settlement {
        val settlementId = data["settlementId"].toString()
        val settlement = settlementDao.getSettlementById(settlementId)
        settlement.status = Constant.SETTLE_STATUS.SETTLED
        settlement.settleTime = Date()
        settlement.chainTransNo
        settlement.updateDate = Date()
        return settlement
    }

    private fun buildInvestDetail(settlement: Settlement): InvestDetail {
        val investDetail = investDetailService.getInvestDetailByInvestNo(settlement.investNo)
        investDetail.unsettledPrincipal = investDetail.unsettledPrincipal.subtract(settlement.settlePrincipal)
        investDetail.updateDate = Date()
        return investDetail
    }

    private fun saveOrUpdateSettlementSum(settlement: Settlement) {

        // 判断该用户是否已经存在投资汇总表
        var settlementSum = settlementSumDao.getSettlementSumByUser(settlement.userNo)
        settlementSum = settlementSum ?: SettlementSum()

        // 计算金额
        if (Constant.SETTLE_STATUS.APPLY == settlement.status) {
            // 待结算总金额=投资人申请结算金额之和
            settlementSum.totalToSettleAmt = settlementSum.totalToSettleAmt.add(settlement.applySettleAmt)
            settlementSum.paidProfit = settlementSum.paidProfit.add(settlement.investorProfit).add(settlement.sealProfit)
        } else if (Constant.SETTLE_STATUS.SETTLED == settlement.status) {
            // 已结算总金额=投资人已结算金额之和
            settlementSum.totalSettledAmt = settlementSum.totalSettledAmt.add(settlement.settlePrincipal)
            settlementSum.toPayProfit = settlementSum.paidProfit.add(settlement.investorProfit).add(settlement.sealProfit)
            // 待结算总金额需要进行扣减
            settlementSum.totalToSettleAmt = settlementSum.totalToSettleAmt.subtract(settlement.applySettleAmt)
            settlementSum.paidProfit = settlementSum.paidProfit.subtract(settlement.investorProfit.add(settlement.sealProfit))
        }

        if (settlementSum.settlementSumId.isEmpty()) {
            settlementSum.settlementSumId = UUID.randomUUID().toString().substring(0, 20)
            settlementSum.userNo = settlement.userNo
            settlementSumDao.createSettlementSum(settlementSum)
        } else {
            settlementSum.updateDate = Date()
            settlementSumDao.updateSettlementSumById(settlementSum)
        }
    }

    fun querySettlementByConditions(qSettlement: QSettlement): List<InvestSettlement> {
        return settlementDao.querySettlementByConditions(qSettlement)
    }
}