package com.seal.ljk.dao

import com.seal.ljk.model.Partner
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface ProtocolDao {

    @Select("select * from protocol")
    fun getAllPartner(): List<Partner>

}