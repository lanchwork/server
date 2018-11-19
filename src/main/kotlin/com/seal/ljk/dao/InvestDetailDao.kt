package com.seal.ljk.dao

import com.seal.ljk.provider.InvestDetailProvider
import com.seal.ljk.query.QInvestDetail
import com.seal.ljk.model.InvestDetail
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface InvestDetailDao {

    @Select("select * from invest_detail where investor_wallet_addr=#{investorWalletAddr} and status=2 limit #{currentPage}, #{pageSize}")
    fun getRepaymentList(@Param("investorWalletAddr") investorWalletAddr: String, @Param("currentPage") currentPage: Int, @Param("pageSize") pageSize: Int): List<InvestDetail>

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