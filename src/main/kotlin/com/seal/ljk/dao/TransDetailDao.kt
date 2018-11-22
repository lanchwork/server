package com.seal.ljk.dao

import com.seal.ljk.model.TransDetail
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface TransDetailDao {

    @Select("select t.trans_detail_id,t.trans_date,t.trans_type,t.platform_trans_no,t.chain_trans_no,t.trans_amt from trans_detail t limit #{currentPage}, #{pageSize} ")
    fun getTransDetailList(@Param("currentPage") currentPage : Int, @Param("pageSize") pageSize : Int): List<TransDetail>

    @Insert("insert into trans_detail(trans_detail_id, trans_date, wallet_addr, trans_type, platform_trans_no, chain_trans_no, trans_amt, create_date, create_user, update_date, update_user, remark) " +
            "values(#{transDetail.transDetailId}, #{transDetail.transDate}, #{transDetail.walletAddr}, #{transDetail.transType}, #{transDetail.platformTransNo}, #{transDetail.chainTransNo}, #{transDetail.transAmt}, #{transDetail.createDate}, #{transDetail.createUser}, #{transDetail.updateDate}, #{transDetail.updateUser}, #{transDetail.remark})")
    fun createTransDetail(@Param("transDetail") transDetail: TransDetail)
}