package com.seal.ljk.provider

import com.seal.ljk.query.QInvestDetail
import org.apache.ibatis.jdbc.SQL

class InvestDetailProvider {

    private val INVEST_DETAIL = "invest_detail"

    fun queryWalletInvestDetail(qInvestDetail: QInvestDetail): String{
        val element = " investor_wallet_addr,  invest_amt, invest_period, day_rate, invest_date, expire_date, " +
                "pre_rcv_amt, partner_id, partner_wallet_addr, invest_id "
        var sql: SQL = SQL().SELECT(element).FROM(INVEST_DETAIL)

        val investorWalletAddr = qInvestDetail.investorWalletAddr
        if(investorWalletAddr.isNotEmpty()){
            sql.WHERE(" investor_wallet_addr LIKE #{investorWalletAddr}")
        }
        val partnerName = qInvestDetail.partnerName
        if(partnerName.isNotEmpty()){
            sql.WHERE(" partner_name LIKE #{partnerName}")
        }
        val investId = qInvestDetail.investId
        if(investId.isNotEmpty()){
            sql.WHERE(" invest_id LIKE #{investId}")
        }
        val investPeriodFrom = qInvestDetail.investPeriodFrom
        if(investPeriodFrom.isNotEmpty()){
            sql.WHERE(" Date(invest_period_from) >= #{investPeriodFrom}")
        }
        val investPeriodTo = qInvestDetail.investPeriodTo
        if(investPeriodTo.isNotEmpty()){
            sql.WHERE(" Date(invest_period_to) <= #{investPeriodTo}")
        }
        val currentPage = (qInvestDetail.currentPage - 1) * qInvestDetail.pageSize
        return sql.toString() + " limit " + currentPage.toString() + ", " + qInvestDetail.pageSize.toString()
    }

    fun queryPaybackInvestDetail(qInvestDetail: QInvestDetail): String{
        val element = " investor_wallet_addr,  invest_amt, invest_period, day_rate, invest_date, expire_date, " +
                "pre_rcv_amt, actual_rcv_date, actual_rcv_amt, partner_id, partner_wallet_addr, status, invest_id "
        var sql: SQL = SQL().SELECT(element).FROM(INVEST_DETAIL)

        val investorWalletAddr = qInvestDetail.investorWalletAddr
        if(investorWalletAddr.isNotEmpty()){
            sql.WHERE(" investor_wallet_addr LIKE #{investorWalletAddr}")
        }
        val partnerName = qInvestDetail.partnerName
        if(partnerName.isNotEmpty()){
            sql.WHERE(" partner_name LIKE #{partnerName}")
        }
        val investId = qInvestDetail.investId
        if(investId.isNotEmpty()){
            sql.WHERE(" invest_id LIKE #{investId}")
        }
        val status = qInvestDetail.status
        if(status.isNotEmpty()){
            sql.WHERE(" status LIKE #{status}")
        }
        val currentPage = (qInvestDetail.currentPage - 1) * qInvestDetail.pageSize
        return sql.toString() + " limit " + currentPage.toString() + ", " + qInvestDetail.pageSize.toString()
    }
}