package com.seal.ljk.dao

import com.seal.ljk.model.LjkCollection
import com.seal.ljk.provider.LjkCollectionProvider
import com.seal.ljk.query.QLjkCollection
import com.seal.ljk.query.QLjkOverdue
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkCollectionDao {

    @SelectProvider(type = LjkCollectionProvider::class, method = "queryLjkCollectionByConditions")
    fun queryLjkCollectionByConditions(qLjkCollection: QLjkCollection): List<LjkCollection>

    @Select("select * from ljk_collection where channel_mark=#{channelMark} and channel_overdue_id=#{channelOverdueId}")
    fun getLjkCollectionByConditions(@Param("channelMark")channelMark:String, @Param("channelOverdueId")channelOverdueId: String): List<LjkCollection>

}
