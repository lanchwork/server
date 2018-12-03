package com.seal.ljk.provider

import com.seal.ljk.query.QPartner
import org.apache.ibatis.jdbc.SQL

class PartnerProvider {

    private val PARTNER = "lc_partner"

    fun getPartnerByCondition(qPartner: QPartner): String {
        val element = " * "
        val sql: SQL = SQL().SELECT(element).FROM(PARTNER)

        val partnerId = qPartner.partnerId
        if (partnerId.isNotEmpty()) {
            sql.WHERE(" partner_id LIKE concat('%',#{partnerId},'%') ")
        }

        val currentPage = (qPartner.currentPage - 1) * qPartner.pageSize
        return sql.toString() + " limit " + currentPage.toString() + ", " + qPartner.pageSize.toString()
    }
}