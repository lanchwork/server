package com.seal.ljk.dao

import com.seal.ljk.model.Partner
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface PartnerDao {

    @Select("select * from partner")
    fun getAllPartner(): List<Partner>

    @Select("select * from partner where partner_Id = #{partnerId}")
    fun getPartnerById(@Param("partnerId") partnerId: String): Partner

    @Insert("insert into partner(partner_Id, channel_Mark, partner_Name, wallet_Addr, is_Open, create_Date, create_User, update_Date, update_User, remark) " +
            "values(#{partner.partnerId}, #{partner.channelMark}, #{partner.partnerName}, #{partner.walletAddr}, #{partner.isOpen}, #{partner.createDate}, #{partner.createUser}, #{partner.updateDate}, #{partner.updateUser}, #{partner.remark})")
    fun createPartner(@Param("partner") partner: Partner): Int

    @Delete("delete from partner where partner_Id = #{partnerId}")
    fun deletePartnerById(@Param("partnerId") partnerId: String): Int

    @Update("update partner set channel_Mark=#{partner.channelMark}, partner_Name=#{partner.partnerName}, wallet_Addr=#{partner.walletAddr}, is_Open=#{partner.isOpen}, update_Date=#{partner.updateDate}, update_User=#{partner.updateUser}, remark=#{partner.remark} " +
            "where partner_Id = #{partner.partnerId}")
    fun updatePartnerById(@Param("partner") partner: Partner): Int

    @Select("select * from partner limit #{currentPage}, #{pageSize}")
    fun getPartnerList(@Param("currentPage") currentPage: Int, @Param("pageSize") pageSize: Int): List<Partner>

    @Select("select partner_Id,channel_Mark,partner_Name from partner where is_Open = 1")
    fun getOpenPartnerList():List<Partner>
}