package com.seal.ljk.dao

import com.seal.ljk.model.LjkCollection
import com.seal.ljk.provider.LjkCollectionProvider
import com.seal.ljk.query.QLjkCollection
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkCollectionDao {

    @SelectProvider(type = LjkCollectionProvider::class, method = "queryLjkCollectionByConditions")
    fun queryLjkCollectionByConditions(qLjkCollection: QLjkCollection): List<LjkCollection>

}
