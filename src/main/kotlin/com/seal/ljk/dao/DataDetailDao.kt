package com.seal.ljk.dao

import com.seal.ljk.model.*
import com.seal.ljk.provider.BusinessObjectProvider
import com.seal.ljk.provider.DataDetailProvider
import com.seal.ljk.query.QDataDetail
import com.seal.ljk.query.QDataDetailBusiness
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface DataDetailDao {

    @Select("SELECT * FROM lc_data_detail where channel_mark_name = #{channelMarkName} and DATE(to_chain_date)=#{toChainDate} ORDER BY business_object ")
    fun queryDataDetailChannel(@Param("channelMarkName") channelMarkName: String,@Param("toChainDate") toChainDate: String): List<DataDetailChannel>

    @SelectProvider(type = DataDetailProvider::class, method = "queryLinkDetail")
    fun queryLinkDetail(qDataDetail: QDataDetail): List<DataDetail>

    @Select("select type,name,showVal,value,remark from lc_dict where type = #{type} and value = #{value}")
    fun getDist(@Param("type") type: String, @Param("value") value: String): Dict

    @Select("SELECT * FROM lc_data_detail where second_hash = #{secondHash} ")
    fun queryToChainVid(@Param("secondHash") secondHash: String): DataDetailLinkChain

    @SelectProvider(type = BusinessObjectProvider::class, method = "queryDataDetailBusiness")
    fun queryDataDetailBusiness(qDataDetailBusiness: QDataDetailBusiness): List<DataDetailLocal>


    @Select("select * from ljk_account_detail where transaction_id = #{transactionId} ")
    fun queryLjkAccountDetail(@Param("transactionId") transactionId: String): List<LjkAccountDetail>

    @Select("select * from ljk_attachment where transaction_id = #{transactionId} ")
    fun queryLjkAttachment(@Param("transactionId") transactionId: String): List<LjkAttachment>

    @Select("select * from ljk_collection where transaction_id = #{transactionId} ")
    fun queryLjkCollection(@Param("transactionId") transactionId: String): List<LjkCollection>

    @Select("select * from ljk_customer where transaction_id = #{transactionId} ")
    fun queryLjkCustomer(@Param("transactionId") transactionId: String): List<LjkCustomer>

    @Select("select * from ljk_customer_detail where transaction_id = #{transactionId} ")
    fun queryLjkCustomerDetail(@Param("transactionId") transactionId: String): List<LjkCustomerDetail>

    @Select("select * from ljk_fin_apply where transaction_id = #{transactionId} ")
    fun queryLjkFinApply(@Param("transactionId") transactionId: String): List<LjkFinApply>

    @Select("select * from ljk_income_statistics where transaction_id = #{transactionId} ")
    fun queryLjkIncomeStatistics(@Param("transactionId") transactionId: String): List<LjkIncomeStatistics>

    @Select("select * from ljk_invest where transaction_id = #{transactionId} ")
    fun queryLjkInvest(@Param("transactionId") transactionId: String): List<LjkInvest>

    @Select("select * from ljk_loan where transaction_id = #{transactionId} ")
    fun queryLjkLoan(@Param("transactionId") transactionId: String): List<LjkLoan>

    @Select("select * from ljk_operational_statistics where transaction_id = #{transactionId} ")
    fun queryLjkOperationalStatistics(@Param("transactionId") transactionId: String): List<LjkOperationalStatistics>

    @Select("select * from ljk_overdue where transaction_id = #{transactionId} ")
    fun queryLjkOverdue(@Param("transactionId") transactionId: String): List<LjkOverdue>

    @Select("select * from ljk_repay where transaction_id = #{transactionId} ")
    fun queryLjkRepay(@Param("transactionId") transactionId: String): List<LjkRepay>

    @Select("select * from ljk_risk where transaction_id = #{transactionId} ")
    fun queryLjkRisk(@Param("transactionId") transactionId: String): List<LjkRisk>

    @Select("select * from ljk_risk_detail where transaction_id = #{transactionId} ")
    fun queryLjkRiskDetail(@Param("transactionId") transactionId: String): List<LjkRiskDetail>

    @Select("select * from ljk_status_change where transaction_id = #{transactionId} ")
    fun queryLjkStatusChange(@Param("transactionId") transactionId: String): List<LjkStatusChange>

}