package com.seal.ljk.dao

import com.seal.ljk.model.User
import com.seal.ljk.provider.UserProvider
import com.seal.ljk.query.QUser
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface UserDao {

    @Insert("insert into user(id,username,password,channel_mark,name,phone,email,role_type,start_flag,create_date,create_user,update_date,update_user)" +
            "values(#{user.id},#{user.username},#{user.password}," +
            "#{user.channelMark},#{user.name},#{user.phone}," +
            "#{user.email},#{user.roleType},#{user.startFlag}," +
            "#{user.createDate},#{user.createUser},#{user.updateDate},#{user.updateUser})")
    fun createUser(@Param("user") user : User)

    @Delete("delete from user where id = #{userId}")
    fun deleteUserById(userId: String)

    @Update("update user set username=#{user.username},password=#{user.password},channel_mark=#{user.channelMark},name=#{user.name},phone=#{user.phone},email=#{user.email},role_type=#{user.roleType},start_flag=#{user.startFlag}, " +
            "create_date=#{user.createDate},create_user=#{user.createUser},update_date=#{user.updateDate},update_user=#{user.updateUser} where id = #{user.id}")
    fun updateUser(@Param("user") user: User)

    @Update("update user set password=#{password} where id = #{userId}")
    fun updatePasswordById(@Param("userId")userId:String,@Param("password")password: String)

    @Select("select id,username,password,channel_mark,name,phone,email,role_type,start_flag,create_date,create_user,update_date,update_user from user where id = #{userId}")
    fun getUserById(userId: String): User

    @SelectProvider(type = UserProvider::class, method = "queryUser")
    fun queryUser(qUser: QUser): List<User>

    @Select("select id,username,password,channel_mark,name,phone,email,role_type,start_flag,create_date,create_user,update_date,update_user from user where username=#{user.username}")
    fun selectUserByUsername(@Param("user") user:User):User




}















