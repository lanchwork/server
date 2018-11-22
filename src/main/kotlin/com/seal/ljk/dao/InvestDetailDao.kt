package com.seal.ljk.dao

import com.seal.ljk.provider.InvestDetailProvider
import com.seal.ljk.query.QInvestDetail
import com.seal.ljk.model.InvestDetail
import com.seal.ljk.model.Partner
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
     * 投资明细查询
     */
    @SelectProvider(type = InvestDetailProvider::class, method = "queryWalletInvestDetail")
    fun queryWalletInvestDetail(qInvestDetail: QInvestDetail): List<InvestDetail>

    /***
     * 回款明细查询
     */
    @SelectProvider(type = InvestDetailProvider::class, method = "queryPaybackInvestDetail")
    fun queryPaybackInvestDetail(qInvestDetail: QInvestDetail): List<InvestDetail>

    @Insert("insert into invest_detail(invest_detail_id, invest_id, chain_trans_no, investor_wallet_addr, invest_amt, invest_period, day_rate, invest_date, expire_date, pre_rcv_principal, pre_income, pre_rcv_amt, actual_rcv_date, actual_rcv_principal, actual_rcv_interest, actual_rcv_amt, partner_id, partner_wallet_addr, overdue_day, status, create_date, create_user, update_date, update_user, remark) " +
            "values(#{investDetail.investDetailId}, #{investDetail.investId}, #{investDetail.chainTransNo}, #{investDetail.investorWalletAddr}, #{investDetail.investAmt}, #{investDetail.investPeriod}, #{investDetail.dayRate}, #{investDetail.investDate}, #{investDetail.expireDate}, #{investDetail.preRcvPrincipal}, #{investDetail.preIncome}, #{investDetail.preRcvAmt}, #{investDetail.actualRcvDate}, #{investDetail.actualRcvPrincipal}, #{investDetail.actualRcvInterest}, #{investDetail.actualRcvAmt}, #{investDetail.partnerId}, #{investDetail.partnerWalletAddr}, #{investDetail.overdueDay}, #{investDetail.status}, #{investDetail.createDate}, #{investDetail.createUser}, #{investDetail.updateDate}, #{investDetail.updateUser}, #{investDetail.remark})")
    fun createInvestDetail(@Param("investDetail") investDetail: InvestDetail)
}