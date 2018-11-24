package com.seal.ljk.service

import com.seal.ljk.dao.DelegateDao
import com.seal.ljk.model.Delegate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DelegateService {
    @Autowired
    lateinit var delegateDao: DelegateDao

    fun getAllDelegate() : List<Delegate> {

        return delegateDao.getAllDelegate()
    }

    fun createDelegate(delegate:Delegate) : Int {

        delegate.createUser = "System"            //创建人
        delegate.createDate = Date()              //创建时间
        return delegateDao.createDelegate( delegate)
    }

    fun deleteDelegateById(partnerProductId : String) : Int {
        return delegateDao.deleteDelegateById(partnerProductId)
    }

    fun updateDelegateById(delegate : Delegate) : Int {
        delegate.updateUser = ""            //修改人
        delegate.updateDate = Date()         //修改时间
        return delegateDao.updateDelegateById(delegate)
    }

    fun getDelegateById(partnerProductId : String) : Delegate {
        return delegateDao.getDelegateById(partnerProductId)
    }

    fun getDelegateList(currentPage : Int, pageSize : Int) : List<Delegate> {
        val currentPageNew = (currentPage - 1) * pageSize
        return delegateDao.getDelegateList(currentPageNew, pageSize)
    }
}