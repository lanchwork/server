package com.seal.ljk.service.impl

import com.seal.ljk.model.TzNoticeInfo
import com.seal.ljk.dao.TzNoticeInfoDao
import com.seal.ljk.service.ITzNoticeInfoService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser

/**
 * <p>
 * 公告 服务实现类
 * </p>
 *
 * @author chenjh
 * @since 2018-12-28
 */
@Service
class TzNoticeInfoServiceImpl : ITzNoticeInfoService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var tzNoticeInfoDao: TzNoticeInfoDao

    override fun getTzNoticeInfo(id: String): TzNoticeInfo? {
        return tzNoticeInfoDao.get(id)
    }

    override fun getAllTzNoticeInfo(tzNoticeInfo: TzNoticeInfo): List<TzNoticeInfo> {
        return tzNoticeInfoDao.getAll(tzNoticeInfo)
    }

    override fun getAllTzNoticeInfoByPage(tzNoticeInfo: TzNoticeInfo): Page<TzNoticeInfo> {
        return tzNoticeInfoDao.getAllByPage(tzNoticeInfo)
    }

    override fun insertTzNoticeInfo(tzNoticeInfo: TzNoticeInfo) {
        tzNoticeInfoDao.insert(tzNoticeInfo)
    }

    override fun updateTzNoticeInfo(tzNoticeInfo: TzNoticeInfo) {
        tzNoticeInfoDao.update(tzNoticeInfo)
    }

    override fun deleteTzNoticeInfo(id: String) {
        tzNoticeInfoDao.delete(id)
    }

}
