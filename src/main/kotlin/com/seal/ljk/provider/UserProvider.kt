package com.seal.ljk.provider

import com.seal.ljk.query.QUser
import org.apache.ibatis.jdbc.SQL

class UserProvider {

    private val USER = "user"

    fun queryUser(qUser: QUser): String{
        val sql:SQL = SQL().SELECT("*").FROM(USER)

        /*查询条件*/
        val channelMark = qUser.channelMark
        if(channelMark.isNotEmpty()){
            sql.WHERE(" channel_mark LIKE #{channelMark}")
        }
        val username = qUser.username
        if(username.isNotEmpty()){
            sql.WHERE(" username LIKE #{username}")
        }
        val startFlag = qUser.startFlag
        if(startFlag.isNotEmpty()){
            sql.WHERE(" start_flag LIKE #{startFlag}")
        }

        //(currentPage-1)*pageSize为当前页的开始行数
        val currentPage = (qUser.currentPage - 1) * qUser.pageSize
        val sqlString: String = sql.toString() + "\nlimit " + currentPage.toString() + ", " + qUser.pageSize.toString()
        return sqlString
    }
}