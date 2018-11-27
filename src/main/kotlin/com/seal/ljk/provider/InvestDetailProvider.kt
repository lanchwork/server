package com.seal.ljk.provider

import com.seal.ljk.query.QInvestDetail
import org.apache.ibatis.jdbc.SQL

class InvestDetailProvider {

    private val INVEST_DETAIL = "invest_detail"

    fun queryAuthorizeInvestDetail(qInvestDetail: QInvestDetail): String{
        val element = " investor_wallet_addr,  invest_amt, invest_period, expect_day_rate, invest_date, partner_id, partner_wallet_addr, invest_no "
        val sql: SQL = SQL().SELECT(element).FROM(INVEST_DETAIL)

        val investorWalletAddr = qInvestDetail.investorWalletAddr
        if(investorWalletAddr.isNotEmpty()){
            sql.WHERE(" investor_wallet_addr LIKE concat('%',#{investorWalletAddr},'%') ")
        }
        val partnerId = qInvestDetail.partnerId
        if(partnerId.isNotEmpty()){
            sql.WHERE(" partner_id LIKE concat('%',#{partnerId},'%') ")
        }
        val investNo = qInvestDetail.investNo
        if(investNo.isNotEmpty()){
            sql.WHERE(" invest_no LIKE concat('%',#{investNo},'%') ")
        }
        val investDateFrom = qInvestDetail.investDateFrom
        if(investDateFrom.isNotEmpty()){
            sql.WHERE(" Date(invest_date_from) >= #{investDateFrom}")
        }
        val investDateTo = qInvestDetail.investDateTo
        if(investDateTo.isNotEmpty()){
            sql.WHERE(" Date(invest_date_to) <= #{investDateTo}")
        }
        val currentPage = (qInvestDetail.currentPage - 1) * qInvestDetail.pageSize
        return sql.toString() + " limit " + currentPage.toString() + ", " + qInvestDetail.pageSize.toString()
    }
}