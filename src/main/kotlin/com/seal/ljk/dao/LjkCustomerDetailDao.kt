package com.seal.ljk.dao

import com.seal.ljk.model.LjkCustomerDetail
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface LjkCustomerDetailDao {

    /**
     * 链金控客户详细信息查询
     */
    @Select("select * from ljk_customer_detail where customer_id=#{customerId}")
    fun getCustomerDetailByKey(customerId: String): List<LjkCustomerDetail>
}