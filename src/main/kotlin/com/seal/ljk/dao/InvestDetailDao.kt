package com.seal.ljk.dao

import com.seal.ljk.model.InvestDetail
import com.seal.ljk.provider.InvestDetailProvider
import com.seal.ljk.query.QInvestDetail
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface InvestDetailDao {

    @Select("select invest_detail_id,invest_id,chain_trans_no,investor_wallet_addr,invest_amt,invest_period,day_rate,invest_date,expire_date,pre_rcv_principal,pre_income,pre_rcv_amt,actual_rcv_date,actual_rcv_principal,actual_rcv_interest,actual_rcv_amt,partner_id,partner_wallet_addr,overdue_day,status,create_date,create_user,update_date,update_user,remark " +
            "from invest_detail where investor_wallet_addr=#{investorWalletAddr} and status in (2,4)  limit #{currentPage}, #{pageSize}")
    fun getRepaymentList(@Param("investorWalletAddr") investorWalletAddr : String,@Param("currentPage") currentPage: Int, @Param("pageSize") pageSize: Int): List<InvestDetail>

    /**
     * 已投资未回款列表
     */
    @Select("select invest_detail_id,invest_id,chain_trans_no,investor_wallet_addr,invest_amt,invest_period,day_rate,invest_date,expire_date,pre_rcv_principal,pre_income,pre_rcv_amt,actual_rcv_date,actual_rcv_principal,actual_rcv_interest,actual_rcv_amt,partner_id,partner_wallet_addr,overdue_day,status,create_date,create_user,update_date,update_user,remark " +
            "from invest_detail where investor_wallet_addr=#{investorWalletAddr} and status in (1,3) limit #{currentPage}, #{pageSize}")
    fun getNonReturnList(@Param("investorWalletAddr") investorWalletAddr : String,@Param("currentPage") currentPage: Int, @Param("pageSize") pageSize: Int): List<InvestDetail>

    /***
     * 授权投资明细查询
     */
    @SelectProvider(type = InvestDetailProvider::class, method = "queryAuthorizeInvestDetail")
    fun queryAuthorizeInvestDetail(qInvestDetail: QInvestDetail): List<InvestDetail>

    /***
     * 投资列表
     */
    @Select("select invest_amt, invest_period, expect_day_rate, invest_no, invest_date, status from invest_detail where user_no = #{userNo}")
    fun getInvestDetailByUser(@Param("userNo") userNo: String): List<InvestDetail>

    @Select("select * from invest_detail where invest_id = #{investId}")
    fun getInvestDetailByInvestId(@Param("investId") investId: String): InvestDetail

    @Insert("insert into invest_detail(invest_detail_id, user_no, invest_no, chain_trans_no, investor_wallet_addr, invest_amt, invest_period, expect_day_rate, invest_date, partner_id, partner_wallet_addr, status, create_date, create_user, update_date, update_user, remark) " +
            "values(#{investDetail.investDetailId}, #{investDetail.userNo}, #{investDetail.investNo}, #{investDetail.chainTransNo}, #{investDetail.investorWalletAddr}, #{investDetail.investAmt}, #{investDetail.investPeriod}, #{investDetail.expectDayRate}, #{investDetail.investDate}, #{investDetail.partnerId}, #{investDetail.partnerWalletAddr}, #{investDetail.status}, #{investDetail.createDate}, #{investDetail.createUser}, #{investDetail.updateDate}, #{investDetail.updateUser}, #{investDetail.remark})")
    fun createInvestDetail(@Param("investDetail") investDetail: InvestDetail)

    @Update("update invest_detail set invest_detail_id=#{investDetail.investDetailId}, user_no=#{investDetail.userNo}, invest_no=#{investDetail.investNo}, chain_trans_no=#{investDetail.chainTransNo}, investor_wallet_addr=#{investDetail.investorWalletAddr}, invest_amt=#{investDetail.investAmt}, invest_period=#{investDetail.investPeriod}, expect_day_rate=#{investDetail.expectDayRate}, invest_date=#{investDetail.investDate}, partner_id=#{investDetail.partnerId}, partner_wallet_addr=#{investDetail.partnerWalletAddr}, status=#{investDetail.status}, create_date=#{investDetail.createDate}, create_user=#{investDetail.createUser}, update_date=#{investDetail.updateDate}, update_user=#{investDetail.updateUser}, remark=#{investDetail.remark}" +
            "where invest_detail_id = #{investDetail.investDetailId}")
    fun updateInvestDetailById(@Param("investDetail") investDetail: InvestDetail)
}