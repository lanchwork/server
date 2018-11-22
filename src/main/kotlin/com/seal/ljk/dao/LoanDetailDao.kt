package com.seal.ljk.dao

import com.seal.ljk.model.LoanDetail
import com.seal.ljk.provider.LoanDetailProvider
import com.seal.ljk.query.QLoanDetail
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface LoanDetailDao {

    @Select("select * from loan_detail where partner_wallet_addr=#{partnerWalletAddr} and `status` in(1,3) limit #{currentPage}, #{pageSize}")
    fun getRepaymentList(@Param("partnerWalletAddr") partnerWalletAddr: String,@Param("currentPage") currentPage: Int, @Param("pageSize") pageSize: Int): List<LoanDetail>

    @SelectProvider(type = LoanDetailProvider::class, method = "queryLoanDetail")
    fun queryByProvider(qLoanDetail: QLoanDetail): List<LoanDetail>

    @Select("select * from loan_detail where partner_Id=#{partnerId} and status in(0,2)")
    fun getNotRepayList(@Param("partner_Id") partnerId: String): List<LoanDetail>

    @Select("select * from loan_detail where loan_detail_id = #{loanDetailId}")
    fun getLoanDetailById(@Param("loanDetailId") loanDetailId: String): LoanDetail

    @Insert("insert into loan_detail(loan_detail_id, partner_id, partner_wallet_addr, loan_id, chain_trans_no, investor_wallet_addr, invest_id, due_prinpal, due_interest, due_amt, due_date, actual_pay_principal, actual_pay_interest, actual_pay_amt, actual_pay_date, loan_period, day_rate, status, overdue_day, invest_date, create_date, create_user, update_date, update_user, remark) " +
            "values(#{loanDetail.loanDetailId}, #{loanDetail.partnerId}, #{loanDetail.partnerWalletAddr}, #{loanDetail.loanId}, #{loanDetail.chainTransNo}, #{loanDetail.investorWalletAddr}, #{loanDetail.investId}, #{loanDetail.duePrinpal}, #{loanDetail.dueInterest}, #{loanDetail.dueAmt}, #{loanDetail.dueDate}, #{loanDetail.actualPayPrincipal}, #{loanDetail.actualPayInterest}, #{loanDetail.actualPayAmt}, #{loanDetail.actualPayDate}, #{loanDetail.loanPeriod}, #{loanDetail.dayRate}, #{loanDetail.status}, #{loanDetail.overdueDay}, #{loanDetail.investDate}, #{loanDetail.createDate}, #{loanDetail.createUser}, #{loanDetail.updateDate}, #{loanDetail.updateUser}, #{loanDetail.remark})")
    fun createLoanDetail(@Param("loanDetail") loanDetail: LoanDetail)

    @Update("update loan_detail set loan_detail_id=#{loanDetail.loanDetailId}, partner_id=#{loanDetail.partnerId}, partner_wallet_addr=#{loanDetail.partnerWalletAddr}, loan_id=#{loanDetail.loanId}, chain_trans_no=#{loanDetail.chainTransNo}, investor_wallet_addr=#{loanDetail.investorWalletAddr}, invest_id=#{loanDetail.investId}, due_prinpal=#{loanDetail.duePrinpal}, due_interest=#{loanDetail.dueInterest}, due_amt=#{loanDetail.dueAmt}, due_date=#{loanDetail.dueDate}, actual_pay_principal=#{loanDetail.actualPayPrincipal}, actual_pay_interest=#{loanDetail.actualPayInterest}, actual_pay_amt=#{loanDetail.actualPayAmt}, actual_pay_date=#{loanDetail.actualPayDate}, loan_period=#{loanDetail.loanPeriod}, day_rate=#{loanDetail.dayRate}, status=#{loanDetail.status}, overdue_day=#{loanDetail.overdueDay}, invest_date=#{loanDetail.investDate}, create_date=#{loanDetail.createDate}, create_user=#{loanDetail.createUser}, update_date=#{loanDetail.updateDate}, update_user=#{loanDetail.updateUser}, remark=#{loanDetail.remark}" +
            "where loan_detail_id = #{loanDetail.loanDetailId}")
    fun updateLoanDetailById(@Param("loanDetail") loanDetail: LoanDetail)
}
