package com.seal.ljk.dao


import com.seal.ljk.model.InvestDetail
import com.seal.ljk.model.LoanDetail
import com.seal.ljk.model.PlatformStatistics
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface PlatformStatisticsDao {

    @Select("select top 1 from table_name order by platform_statistics_id desc")
    fun getPlatformStatisticsLast(): PlatformStatistics?

    @Insert("insert into platform_statistics(platform_statistics_id, " +
            "statistics_date, total_trans_amt, total_trans_num, total_income_amt, " +
            "total_bad_debt_num, bad_debt_rate, total_overdue_num, overdue_rate, " +
            "remark) " +
            "values(#{platformStatistics.platformStatisticsId},#{platformStatistics.statisticsDate}," +
            "#{platformStatistics.totalTransAmt},#{platformStatistics.totalTransNum}," +
            "#{platformStatistics.totalIncomeAmt},#{platformStatistics.totalBadDebtNum}," +
            "#{platformStatistics.badDebtRate},#{platformStatistics.totalOverdueNum}," +
            "#{platformStatistics.overdueRate},#{platformStatistics.remark})")
    fun createPlatformStatistics(@Param("platformStatistics")  platformStatistics:PlatformStatistics):Int

    @Select("select * from invest_detail")
    fun getAllInvestDetail():List<InvestDetail>

    @Select("select * from loan_detail")
    fun getAllLoanDetail():List<LoanDetail>
}











