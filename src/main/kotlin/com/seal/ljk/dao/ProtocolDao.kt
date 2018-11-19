package com.seal.ljk.dao

import com.seal.ljk.model.Protocol
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface ProtocolDao {

    @Select("select protocol_id,protocol_type,protocol_name,protocol_no,protocol_content,create_date,create_user,update_date,update_user,remark " +
            "from protocol")
    fun getAllPartner(): List<Protocol>

}