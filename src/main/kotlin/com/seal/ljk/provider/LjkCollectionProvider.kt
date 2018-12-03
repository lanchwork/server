package com.seal.ljk.provider

import com.seal.ljk.query.QLjkCollection
import org.apache.ibatis.jdbc.SQL

class LjkCollectionProvider {

    private val LJK_COLLECTION = "ljk_collection"

    fun queryLjkCollectionByConditions(qLjkCollection: QLjkCollection): String{
        val sql:SQL = SQL().SELECT("*").FROM(LJK_COLLECTION)

        /*查询条件*/
        val collectionId = qLjkCollection.collectionId
        if(collectionId.isNotEmpty()){
            sql.WHERE(" collection_id LIKE concat('%',#{collectionId},'%')")
        }
        val collectioner = qLjkCollection.collectioner
        if(collectioner.isNotEmpty()){
            sql.WHERE(" collectioner LIKE concat('%',#{collectioner},'%')")
        }
        val channelFinApplyId = qLjkCollection.channelFinApplyId
        if(channelFinApplyId.isNotEmpty()){
            sql.WHERE(" channel_fin_apply_id LIKE concat('%',#{channelFinApplyId},'%')")
        }

        val collectionDateFrom = qLjkCollection.collectionDateFrom
        if(collectionDateFrom.isNotEmpty()){
            sql.WHERE(" Date(collection_date) >= #{collectionDateFrom}")
        }
        val collectionDateTo = qLjkCollection.collectionDateTo
        if(collectionDateTo.isNotEmpty()){
            sql.WHERE(" Date(collection_date) <= #{collectionDateTo}")
        }
        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qLjkCollection.currentPage - 1) * qLjkCollection.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qLjkCollection.pageSize.toString()
        return sqlString
    }
}