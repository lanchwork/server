package com.seal.ljk.dao

import com.seal.ljk.model.Loan
import com.seal.ljk.model.Partner
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface LoanDao {

    @Select("select * from loan where loaner_wallet_addr = #{loanerWalletAddr}")
    fun getPartnerById(@Param("loanerWalletAddr") loanerWalletAddr : String): Loan


}