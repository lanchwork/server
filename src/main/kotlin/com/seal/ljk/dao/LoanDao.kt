package com.seal.ljk.dao

import com.seal.ljk.model.Loan
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface LoanDao {

    @Select("select loan_id,loaner_wallet_addr,total_repay_amt,total_loan_amt,pay_interest,unpay_interest,total_pay_amt,create_date,create_user,update_date,update_user,remark " +
            "from loan where loaner_wallet_addr = #{loanerWalletAddr}")
    fun getPartnerById(@Param("loanerWalletAddr") loanerWalletAddr : String): Loan

    @Select("select loan_id, loaner_wallet_addr, total_repay_amt, total_loan_amt, pay_interest, unpay_interest, total_pay_amt, create_date, create_user, update_date, update_user, remark from loan where loan_id = #{loanId}")
    fun getLoanById(@Param("loanId") loanId: String): Loan

    @Insert("insert into loan(loan_id, loaner_wallet_addr, total_repay_amt, total_loan_amt, pay_interest, unpay_interest, total_pay_amt, create_date, create_user, update_date, update_user, remark) " +
            "values(#{loan.loanId}, #{loan.loanerWalletAddr}, #{loan.totalRepayAmt}, #{loan.totalLoanAmt}, #{loan.payInterest}, #{loan.unpayInterest}, #{loan.totalPayAmt}, #{loan.createDate}, #{loan.createUser}, #{loan.updateDate}, #{loan.updateUser}, #{loan.remark})")
    fun createLoan(@Param("loan") loan: Loan)

    @Update("update loan set loan_id=#{loan.loanId}, loaner_wallet_addr=#{loan.loanerWalletAddr}, total_repay_amt=#{loan.totalRepayAmt}, total_loan_amt=#{loan.totalLoanAmt}, pay_interest=#{loan.payInterest}, unpay_interest=#{loan.unpayInterest}, total_pay_amt=#{loan.totalPayAmt}, create_date=#{loan.createDate}, create_user=#{loan.createUser}, update_date=#{loan.updateDate}, update_user=#{loan.updateUser}, remark=#{loan.remark}" +
            "where loan_id = #{loan.loanId}")
    fun updateLoanById(@Param("loan") loan: Loan)
}