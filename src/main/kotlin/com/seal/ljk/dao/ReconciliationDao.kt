package com.seal.ljk.dao

import com.seal.ljk.model.Reconciliation
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface ReconciliationDao {

    @Select("select * from reconciliation")
    fun getAllReconciliation(): List<Reconciliation>

    @Select("select * from reconciliation where partner_Id = #{partnerId}")
    fun getReconciliationById(@Param("partnerId") partnerId: String): Reconciliation

    @Select("select * from reconciliation limit #{currentPage}, #{pageSize}")
    fun getReconciliationList(@Param("currentPage") currentPage: Int, @Param("pageSize") pageSize: Int): List<Reconciliation>

}