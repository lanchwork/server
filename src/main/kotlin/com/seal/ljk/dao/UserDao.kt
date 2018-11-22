package com.seal.ljk.dao

import com.seal.ljk.model.User
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface UserDao {

    @Insert("insert into user(id,username,password,channel_mark,name,phone,email,role_type,is_start)" +
            "values(#{user.id},#{user.username},#{user.password}," +
            "#{user.channelMark},#{user.name},#{user.phone}," +
            "#{user.email},#{user.roleType},#{user.isStart})")
    fun create(@Param("user") user : User)

}















