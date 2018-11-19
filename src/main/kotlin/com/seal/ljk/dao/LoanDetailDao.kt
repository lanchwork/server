package com.seal.ljk.dao

import com.seal.ljk.Provider.LoanDetailProvider
import com.seal.ljk.Query.QLoanDetail
import com.seal.ljk.model.LoanDetail
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface LoanDetailDao {

    @Select("select * from loan_detail where partner_wallet_addr=#{partnerWalletAddr} and status in(1,3) limit #{currentPage}, #{pageSize}")
    fun getRepaymentList(@Param("partnerWalletAddr") partnerWalletAddr: String,@Param("currentPage") currentPage: Int, @Param("pageSize") pageSize: Int): List<LoanDetail>

    @SelectProvider(type = LoanDetailProvider::class, method = "queryLoanDetail")
    fun queryByProvider(qLoanDetail: QLoanDetail): List<LoanDetail>

}
