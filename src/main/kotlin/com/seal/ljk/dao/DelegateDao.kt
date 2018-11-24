package com.seal.ljk.dao

import com.seal.ljk.model.Delegate
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface DelegateDao {

    @Select("select * from delegate")
    fun getAllDelegate(): List<Delegate>

    @Select("select * from delegate where delegate_id = #{delegateId}")
    fun getDelegateById(@Param("delegateId") delegateId : String): Delegate

    @Insert("insert into delegate(" +
            "delegate_id, allot_profit_id, entrust_deadline, expect_day_rate, guarantee_way, open_flag, deadline, remark, create_date, create_user, update_date, update_user" +
            ") values(" +
            "#{delegate.delegateId}, #{delegate.allotProfitId}, #{delegate.entrustDeadline}, #{delegate.expectDayRate}, #{delegate.guaranteeWay}, #{delegate.openFlag}, #{delegate.deadline}, #{delegate.remark}, #{delegate.createDate}, #{delegate.createUser}, #{delegate.updateDate}, #{delegate.updateUser})")
    @Options(useGeneratedKeys = true, keyProperty = "delegateId")
    fun createDelegate(@Param("delegate") delegate : Delegate):Int

    @Delete("delete from delegate where delegate_id = #{delegateId}")
    fun deleteDelegateById(@Param("delegateId") delegateId: String):Int

    @Update("update delegate set  allot_Profit_Id=#{delegate.allotProfitId}, entrust_deadline=#{delegate.entrustDeadline}, expect_day_rate=#{delegate.expectDayRate}, guarantee_way=#{delegate.guaranteeWay}, open_flag=#{delegate.openFlag}, deadline=#{delegate.deadline}, remark=#{delegate.remark}, create_Date=#{delegate.createDate}, create_User=#{delegate.createUser}, update_Date=#{delegate.updateDate}, update_User=#{delegate.updateUser} where delegate_id=#{delegate.delegateId}")
    fun updateDelegateById(@Param("delegate") delegate :Delegate ): Int

    @Select("select partner_product_id, allot_profit_id, product_name, day_rate, open_flag, end_date, remark, create_date, create_user, update_date, update_user from partner_product limit #{currentPage}, #{pageSize}")
    fun getDelegateList(@Param("currentPage") currentPage : Int, @Param("pageSize") pageSize : Int): List<Delegate>

}