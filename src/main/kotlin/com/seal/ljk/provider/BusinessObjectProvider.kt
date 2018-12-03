package com.seal.ljk.provider

import com.seal.ljk.query.QDataDetailBusiness
import org.apache.ibatis.jdbc.SQL

class BusinessObjectProvider {

    private val AccountDetail = "ljk_account_detail"
    private val Attachment = "ljk_attachment"
    private val Collection = "ljk_collection"
    private val Customer = "ljk_customer"
    private val CustomerDetail = "ljk_customer_detail"
    private val FinApply = "ljk_fin_apply"
    private val IncomeStatistics = "ljk_income_statistics"
    private val Invest = "ljk_invest"
    private val Loan = "ljk_loan"
    private val OperationalStatistics = "ljk_operational_statistics"
    private val Overdue = "ljk_overdue"
    private val Repay = "ljk_repay"
    private val Risk = "ljk_risk"
    private val RiskDetail = "ljk_risk_detail"
    private val StatusChange = "ljk_status_change"

    fun queryDataDetailBusiness(qDataDetailBusiness: QDataDetailBusiness): String {
        val sql: SQL = SQL()
        if (qDataDetailBusiness.businessObject.equals("AccountDetail")) {
            sql.SELECT(" channe_account_serial_no as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(AccountDetail)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" channe_account_serial_no LIKE concat('%',#{channelCustomerId},'%') ")
            }

        } else if (qDataDetailBusiness.businessObject.equals("Attachment")) {
            sql.SELECT(" channelAttachment_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(Attachment)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" channelAttachment_id LIKE concat('%',#{channelCustomerId},'%') ")
            }
        } else if (qDataDetailBusiness.businessObject.equals("Customer")) {
            sql.SELECT(" channel_customer_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(Customer)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" channel_customer_id LIKE concat('%',#{channelCustomerId},'%') ")
            }

        } else if (qDataDetailBusiness.businessObject.equals("CustomerDetail")) {
            sql.SELECT(" channel_customer_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(CustomerDetail)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" channel_customer_id LIKE concat('%',#{channelCustomerId},'%') ")
            }
        } else if (qDataDetailBusiness.businessObject.equals("FinApply")) {
            sql.SELECT(" channel_fin_apply_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(FinApply)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" channel_fin_apply_id LIKE concat('%',#{channelCustomerId},'%') ")
            }
        } else if (qDataDetailBusiness.businessObject.equals("IncomeStatistics")) {
            sql.SELECT(" income_statistics_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(IncomeStatistics)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" income_statistics_id LIKE concat('%',#{channelCustomerId},'%') ")
            }
        } else if (qDataDetailBusiness.businessObject.equals("Invest")) {
            sql.SELECT(" channel_invest_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(Invest)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" channel_invest_id LIKE concat('%',#{channelCustomerId},'%') ")
            }
        } else if (qDataDetailBusiness.businessObject.equals("Loan")) {
            sql.SELECT(" channel_loanId as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(Loan)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" channel_loanId LIKE concat('%',#{channelCustomerId},'%') ")
            }
        } else if (qDataDetailBusiness.businessObject.equals("OperationalStatistics")) {
            sql.SELECT(" operational_statistics_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(OperationalStatistics)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" operational_statistics_id LIKE concat('%',#{channelCustomerId},'%') ")
            }
        } else if (qDataDetailBusiness.businessObject.equals("Overdue")) {
            sql.SELECT(" channel_overdue_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(Overdue)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" channel_overdue_id LIKE concat('%',#{channelCustomerId},'%') ")
            }
        } else if (qDataDetailBusiness.businessObject.equals("Repay")) {
            sql.SELECT(" channel_repay_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(Repay)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" channel_repay_id LIKE concat('%',#{channelCustomerId},'%') ")
            }
        } else if (qDataDetailBusiness.businessObject.equals("Risk")) {
            sql.SELECT(" channel_customer_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(Risk)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" channel_customer_id LIKE concat('%',#{channelCustomerId},'%') ")
            }
        } else if (qDataDetailBusiness.businessObject.equals("RiskDetail")) {
            sql.SELECT(" channel_customer_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(RiskDetail)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" channel_customer_id LIKE concat('%',#{channelCustomerId},'%') ")
            }
        } else {
            sql.SELECT(" status_change_id as channelCustomerId,channel_mark as channelMark,transaction_id as transactionId,from_party as fromParty,local_hash as localHash,updateTime ").FROM(StatusChange)

            val channelCustomerId = qDataDetailBusiness.channelCustomerId
            if (channelCustomerId.isNotEmpty()) {
                sql.WHERE(" status_change_id LIKE concat('%',#{channelCustomerId},'%') ")
            }
        }

        /*查询条件*/
        val channelMark = qDataDetailBusiness.channelMark
        sql.WHERE(" channel_mark = #{channelMark} ")

        val updateTime = qDataDetailBusiness.updateTime
        if (updateTime.isNotEmpty()) {
            sql.WHERE(" updateTime = #{updateTime} ")
        }

        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qDataDetailBusiness.currentPage - 1) * qDataDetailBusiness.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qDataDetailBusiness.pageSize.toString()
        return sqlString
    }
}