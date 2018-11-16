package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.dao.ProtocolDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/protocol")
class ProtocolController {

    @Autowired
    lateinit var protocolDao: ProtocolDao

    /*查看协议*/
    @GetMapping("/all")
    fun getAllPartner(): ResVal {
        try {
            protocolDao.getAllPartner()
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, protocolDao.getAllPartner())
    }

}