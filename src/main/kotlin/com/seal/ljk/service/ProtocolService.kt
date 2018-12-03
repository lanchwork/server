package com.seal.ljk.service

import com.seal.ljk.dao.ProtocolDao
import com.seal.ljk.model.Protocol
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProtocolService {



    @Autowired
    lateinit var protocolDao: ProtocolDao

    /*查看协议*/
    fun getAllPartner(): List<Protocol> {
        return protocolDao.getAllPartner();
    }
}