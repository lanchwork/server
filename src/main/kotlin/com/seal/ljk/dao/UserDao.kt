package com.seal.ljk.dao

import com.seal.ljk.model.User
import com.seal.ljk.provider.UserProvider
import com.seal.ljk.query.QUser
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface UserDao {

    @Insert("insert into user(id,username,password,channel_mark,name,phone,email,role_type,start_flag)" +
            "values(#{user.id},#{user.username},#{user.password}," +
            "#{user.channelMark},#{user.name},#{user.phone}," +
            "#{user.email},#{user.roleType},#{user.startFlag})")
    fun createUser(@Param("user") user : User)

    @Delete("delete from user where id = #{userId}")
    fun deleteUserById(userId: String)

    @Update("update user set username=#{user.username},password=#{user.password},channel_mark=#{user.channelMark},name=#{user.name},phone=#{user.phone},email=#{user.email},role_type=#{user.roleType},start_flag=#{user.startFlag} where id = #{user.id}")
    fun updateUser(@Param("user") user: User)

    @Select("select id,username,password,channel_mark,name,phone,email,role_type,start_flag from user where id = #{userId}")
    fun getUserById(userId: String): User

    @SelectProvider(type = UserProvider::class, method = "queryUser")
    fun queryUser(qUser: QUser): List<User>

    @Select("select id,username,password,channel_mark,name,phone,email,role_type,start_flag from user where username=#{user.username}")
    fun selectUserByUsername(@Param("user") user:User):User


}















