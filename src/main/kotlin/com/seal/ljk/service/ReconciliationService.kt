package com.seal.ljk.service

import com.seal.ljk.dao.ReconciliationDao
import com.seal.ljk.model.Reconciliation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReconciliationService {
    @Autowired
    lateinit var reconciliationDao: ReconciliationDao

    fun getAllReconciliation(): List<Reconciliation> {
        return reconciliationDao.getAllReconciliation()
    }

    fun getReconciliationById(partnerId: String): Reconciliation {
        return reconciliationDao.getReconciliationById(partnerId)
    }

    fun getReconciliationList(currentPage: Int, pageSize: Int): List<Reconciliation> {
        return reconciliationDao.getReconciliationList(currentPage, pageSize)
    }
}