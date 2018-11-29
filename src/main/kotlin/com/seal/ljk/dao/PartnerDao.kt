package com.seal.ljk.dao

import com.seal.ljk.model.Partner
import com.seal.ljk.provider.PartnerProvider
import com.seal.ljk.query.QPartner
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface PartnerDao {

    @SelectProvider(type = PartnerProvider::class, method = "getPartnerByCondition")
    fun getPartnerByCondition(qPartner: QPartner): List<Partner>

    @Select("select * from partner")
    fun getAllPartner(): List<Partner>

    @Select("select * from partner where partner_id = #{partnerId}")
    fun getPartnerById(@Param("partnerId") partnerId: String): Partner

    @Insert("insert into partner(partner_id, channel_mark, partner_name, user_no, wallet_addr, open_flag, create_date, create_user, update_date, update_user, remark) " +
            "values(#{partner.partnerId}, #{partner.channelMark}, #{partner.partnerName}, #{partner.userNo}, #{partner.walletAddr}, #{partner.openFlag}, #{partner.createDate}, #{partner.createUser}, #{partner.updateDate}, #{partner.updateUser}, #{partner.remark})")
    fun createPartner(@Param("partner") partner: Partner): Int

    @Delete("delete from partner where partner_Id = #{partnerId}")
    fun deletePartnerById(@Param("partnerId") partnerId: String): Int

    @Update("update partner set channel_mark=#{partner.channelMark}, partner_name=#{partner.partnerName}, user_no=#{partner.userNo}, wallet_addr=#{partner.walletAddr}, open_flag=#{partner.isOpen}, update_date=#{partner.updateDate}, update_user=#{partner.updateUser}, remark=#{partner.remark} " +
            "where partner_id = #{partner.partnerId}")
    fun updatePartnerById(@Param("partner") partner: Partner): Int

    @Select("select * from partner limit #{currentPage}, #{pageSize}")
    fun getPartnerList(@Param("currentPage") currentPage: Int, @Param("pageSize") pageSize: Int): List<Partner>

    @Select("select partner_id,channel_mark,partner_name from partner where open_flag = 1")
    fun getOpenPartnerList():List<Partner>
}