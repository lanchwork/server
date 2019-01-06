package com.seal.ljk.service.impl

import com.seal.ljk.model.SysDictItem
import com.seal.ljk.dao.SysDictItemDao
import com.seal.ljk.service.ISysDictItemService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.SealException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser

/**
 * <p>
 *  数据项列表服务实现类
 * </p>
 *
 * @author lanch
 * @since 2019-01-03
 */
@Service
class SysDictItemServiceImpl : ISysDictItemService {
    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var sysDictItemDao: SysDictItemDao

    override fun getSysDictItem(id: String): SysDictItem {
        return sysDictItemDao.get(id) ?: throw SealException(message = "id 数据项不存在。")
    }

    override fun getAllSysDictItem(sysDictItem: SysDictItem): List<SysDictItem> {
        return sysDictItemDao.getAll(sysDictItem)
    }

    override fun getAllSysDictItemByPage(sysDictItem: SysDictItem): Page<SysDictItem> {
        val newSysDictItem=SysDictItem()
        newSysDictItem.delFlag = "0"
        newSysDictItem.typeId=sysDictItem.typeId
        return sysDictItemDao.getAllByPage(newSysDictItem)
    }

    override fun insertSysDictItem(sysDictItem: SysDictItem) {
        sysDictItem.delFlag = "0"
        sysDictItem.sort = 0
        sysDictItemDao.insert(sysDictItem)
    }

    override fun updateSysDictItem(sysDictItem: SysDictItem) {
        sysDictItemDao.update(sysDictItem)
    }

    /**
     * 此处为假删, 只将数据deleteFlag设置为1
     */
    override fun deleteSysDictItem(id: String) {
        val sysDictItem = SysDictItem(id = id,delFlag = "1")
        sysDictItemDao.update(sysDictItem)
    }

}
