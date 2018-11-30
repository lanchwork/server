package com.seal.ljk.dao

import com.seal.ljk.model.LjkCustomer
import com.seal.ljk.provider.LjkCustomerProvider
import com.seal.ljk.query.QLjkCustomer
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkCustomerDao {

    /**
     * 链金控客户基本信息查询
     */
    @SelectProvider(type = LjkCustomerProvider::class, method = "queryCustomer")
    fun queryLjkCustomer(qLjkCustomer: QLjkCustomer): List<LjkCustomer>

}