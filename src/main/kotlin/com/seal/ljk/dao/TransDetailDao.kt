package com.seal.ljk.dao

import com.seal.ljk.model.Partner
import com.seal.ljk.model.TransDetail
import com.seal.ljk.model.User
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface TransDetailDao {

    @Select("select t.trans_detail_id,t.trans_date,t.trans_type,t.platform_trans_no,t.chain_trans_no,t.trans_amt from trans_detail t limit #{currentPage}, #{pageSize} ")
    fun getTransDetailList(@Param("currentPage") currentPage : Int, @Param("pageSize") pageSize : Int): List<TransDetail>

}