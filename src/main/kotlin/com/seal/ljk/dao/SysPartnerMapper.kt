package com.seal.ljk.dao;

import com.seal.ljk.model.SysPartner

/**
 * <p>
 * 合作方表 Mapper 接口
 * </p>
 *
 * @author chenjh
 * @since 2018-12-24
 */
interface SysPartnerMapper : BaseMapper<SysPartner> {
    fun getByChannelMark(channelMark: String): SysPartner?
}
