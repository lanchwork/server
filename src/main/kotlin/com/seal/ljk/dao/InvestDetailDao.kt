package com.seal.ljk.dao

import com.seal.ljk.provider.InvestDetailProvider
import com.seal.ljk.query.QInvestDetail
import com.seal.ljk.model.InvestDetail
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface InvestDetailDao {

    @Select("select invest_detail_id,invest_id,chain_trans_no,investor_wallet_addr,invest_amt,invest_period,day_rate,invest_date,expire_date,pre_rcv_principal,pre_income,pre_rcv_amt,actual_rcv_date,actual_rcv_principal,actual_rcv_interest,actual_rcv_amt,partner_id,partner_wallet_addr,overdue_day,status,create_date,create_user,update_date,update_user,remark " +
            "from invest_detail where investor_wallet_addr=#{investorWalletAddr} and status in (2,4)  limit #{currentPage}, #{pageSize}")
    fun getRepaymentList(@Param("investorWalletAddr") investorWalletAddr : String,@Param("currentPage") currentPage: Int, @Param("pageSize") pageSize: Int): List<InvestDetail>

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

}