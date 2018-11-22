package com.seal.ljk.dao

import com.seal.ljk.model.Loan
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface LoanDao {

    @Select("select loan_id,loaner_wallet_addr,total_repay_amt,total_loan_amt,pay_interest,unpay_interest,total_pay_amt,create_date,create_user,update_date,update_user,remark " +
            "from loan where loaner_wallet_addr = #{loanerWalletAddr}")
    fun getPartnerById(@Param("loanerWalletAddr") loanerWalletAddr : String): Loan


    @Insert("insert into loan(loan_id, loaner_wallet_addr, total_repay_amt, total_loan_amt, pay_interest, unpay_interest, total_pay_amt, create_date, create_user, update_date, update_user, remark) " +
            "values(#{loan.loanId}, #{loan.loanerWalletAddr}, #{loan.totalRepayAmt}, #{loan.totalLoanAmt}, #{loan.payInterest}, #{loan.unpayInterest}, #{loan.totalPayAmt}, #{loan.createDate}, #{loan.createUser}, #{loan.updateDate}, #{loan.updateUser}, #{loan.remark})")
    fun createLoan(@Param("loan") loan: Loan)
}