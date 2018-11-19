package com.seal.ljk.dao

import com.seal.ljk.model.Invest
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface InvestDao {

    @Select("select invest_id,investor_wallet_addr,total_pending_amt,total_invest_amt,earned_amt,unearned_amt,create_date,create_user,update_date,update_user,remark " +
            "from invest where investor_wallet_addr = #{investorWalletAddr}")
    fun getPartnerById(@Param("investorWalletAddr") investorWalletAddr : String): Invest

}