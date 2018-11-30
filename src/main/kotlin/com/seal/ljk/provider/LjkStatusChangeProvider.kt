package com.seal.ljk.provider

import com.seal.ljk.query.QLjkStatusChange
import com.seal.ljk.query.QSettlement
import org.apache.ibatis.jdbc.SQL

class LjkStatusChangeProvider {

    private val LJK_STATUS_CHANGE = "ljk_status_change"

    fun queryLjkStatusChangeByConditions(qLjkStatusChange: QLjkStatusChange): String{
        val sql:SQL = SQL().SELECT("*").FROM(LJK_STATUS_CHANGE)

        /*查询条件*/
        val statusChangeId = qLjkStatusChange.statusChangeId
        if(statusChangeId.isNotEmpty()){
            sql.WHERE(" status_change_id LIKE concat('%',#{statusChangeId},'%')")
        }
        val businessObject = qLjkStatusChange.businessObject
        if(businessObject.isNotEmpty()){
            sql.WHERE(" business_object LIKE concat('%',#{businessObject},'%')")
        }
        val businessObjectId = qLjkStatusChange.businessObjectId
        if(businessObjectId.isNotEmpty()){
            sql.WHERE("business_objectId LIKE concat('%',#{businessObjectId},'%')")
        }

        val currentState = qLjkStatusChange.currentState
        if(currentState.isNotEmpty()){
            sql.WHERE("current_state LIKE concat('%',#{currentState},'%')")
        }

        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkStatusChange.currentPage - 1) * qLjkStatusChange.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkStatusChange.pageSize.toString()
        return sqlString
    }
}