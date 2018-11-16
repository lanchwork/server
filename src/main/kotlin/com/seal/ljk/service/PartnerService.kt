package com.seal.ljk.service

import com.seal.ljk.dao.PartnerDao
import com.seal.ljk.model.Partner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PartnerService {

    @Autowired
    lateinit var partnerDao: PartnerDao

    fun getAllPartner(): List<Partner> {
        return partnerDao.getAllPartner()
    }

    fun getPartnerById(partnerId: String): Partner {
        return partnerDao.getPartnerById(partnerId)
    }

    fun createPartner(partner: Partner): Int {
        return partnerDao.createPartner(partner)
    }

    fun deletePartnerById(partnerId: String): Int {
        return partnerDao.deletePartnerById(partnerId)
    }

    fun updatePartnerById(partner: Partner): Int {
        return partnerDao.updatePartnerById(partner)
    }

    fun getPartnerList(currentPage: Int, pageSize: Int): List<Partner> {
        return partnerDao.getPartnerList(currentPage, pageSize)
    }
}