package com.seal.ljk.service

import com.seal.ljk.dao.SettlementDao
import com.seal.ljk.dao.SettlementSumDao
import com.seal.ljk.model.Settlement
import com.seal.ljk.model.SettlementSum
import com.seal.ljk.query.QSettlement
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.util.*

@Service
open class SettlementService {

    @Autowired
    lateinit var settlementDao: SettlementDao

    @Autowired
    lateinit var settlementSumDao: SettlementSumDao

    fun getSettlementListByUserNo(qSettlement: QSettlement): List<Settlement> {
        return settlementDao.getSettlementListByUserNo(qSettlement)
    }

    @Transactional
    open fun saveWantSettlement(data: Map<String, Any>) {
        // 结算的操作是合作方的角色才会操作的。

        // 生成结算
        val settlement = this.buildSettlement(data)

        // 生成结算汇总
        this.saveOrUpdateSettlementSum(settlement)
    }

    private fun buildSettlement(data: Map<String, Any>): Settlement {

        // 界面输入
        val investorWalletAddr = data["investorWalletAddr"].toString()
        val settlementAmt = data["settlementAmt"].toString()
        val sealWalletAddr = data["sealWalletAddr"].toString()
        val distributableAmt = data["distributableAmt"].toString()

        // 从当前session中获取？
        val partnerWalletAddr = data["partnerWalletAddr"].toString()
        val userNo = data["userNo"].toString()

        // 从待结算明细页面带过来
        val investNo = data["investNo"].toString()

        var settlement = Settlement()
        settlement.settlementId = UUID.randomUUID().toString().substring(0, 20)
        settlement.userNo = userNo
        settlement.investNo = investNo
        settlement.applySettleAmt = BigDecimal(settlementAmt)
        settlement.applyTime = Date()
        settlement.settlePrincipal
        settlement.investorProfit
        settlement.sealProfit
        settlement.status
        settlement.settleTime
        settlement.chainTransNo
        settlement.investorWalletAddr = investorWalletAddr
        settlement.partnerWalletAddr = partnerWalletAddr
        settlement.sealWalletAddr = sealWalletAddr

        return settlement
    }

    private fun saveOrUpdateSettlementSum(settlement: Settlement) {

        // 判断该用户是否已经存在投资汇总表
        var settlementSum = settlementSumDao.getSettlementSumByUser(settlement.userNo)
        settlementSum = settlementSum ?: SettlementSum()

        // 计算金额
        settlementSum.totalToSettleAmt
        settlementSum.totalSettledAmt
        settlementSum.paidProfit
        settlementSum.toPayProfit

        if (settlementSum.settlementSumId.isEmpty()) {
            settlementSum.settlementSumId = UUID.randomUUID().toString().substring(0, 20)
            settlementSum.userNo = settlement.userNo
            settlementSumDao.createSettlementSum(settlementSum)
        } else {
            settlementSumDao.updateSettlementSumById(settlementSum)
        }
    }
}