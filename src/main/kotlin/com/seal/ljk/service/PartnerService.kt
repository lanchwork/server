package com.seal.ljk.service

import com.seal.ljk.dao.PartnerDao
import com.seal.ljk.model.CompanyInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PartnerService {
    @Autowired
    lateinit var partnerDao: PartnerDao

    fun getCompanyInfo(partner: String): CompanyInfo {
        var companyInfo: CompanyInfo = CompanyInfo()



        return companyInfo
    }
}