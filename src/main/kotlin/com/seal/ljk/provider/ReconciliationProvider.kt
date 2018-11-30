package com.seal.ljk.provider

import com.seal.ljk.query.QReconciliation
import org.apache.ibatis.jdbc.SQL

class ReconciliationProvider {

    private val RECONCILIATION = "lc_reconciliation"

    fun getReconciliationByCondition(qReconciliation: QReconciliation): String {
        val element = " * "
        val sql: SQL = SQL().SELECT(element).FROM(RECONCILIATION)

        val partnerId = qReconciliation.partnerId
        if (partnerId.isNotEmpty()) {
            sql.WHERE(" partner_id LIKE concat('%',#{partnerId},'%') ")
        }

        val currentPage = (qReconciliation.currentPage - 1) * qReconciliation.pageSize
        return sql.toString() + " limit " + currentPage.toString() + ", " + qReconciliation.pageSize.toString()
    }
    
}