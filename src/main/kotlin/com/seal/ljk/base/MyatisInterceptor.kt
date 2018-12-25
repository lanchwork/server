package com.seal.ljk.base

import com.seal.ljk.common.UUIDUtil
import com.seal.ljk.common.getSessionUser
import com.seal.ljk.model.Base
import org.apache.ibatis.mapping.MappedStatement
import org.apache.ibatis.mapping.SqlCommandType
import org.apache.ibatis.executor.Executor
import org.apache.ibatis.plugin.*
import java.util.*
import java.lang.reflect.Field


/**
 * Created by chenjh on 2018/12/25.
 */
@Intercepts(
    Signature(
        type = Executor::class,
        method = "update",
        args = arrayOf(MappedStatement::class, Any::class)
    )
)
class SealSqlInterceptor : Interceptor {
    override fun intercept(invocation: Invocation): Any {
        
        val mappedStatement = invocation.args[0] as MappedStatement
        
        // 获取 SQL 命令
        val sqlCommandType = mappedStatement.sqlCommandType
        
        // 获取参数
        val parameter = invocation.args[1]
    
        val declaredFields = mutableListOf<Field>()
        var tempClass = parameter.javaClass
        while (true) {
            declaredFields.addAll(tempClass.declaredFields)
            tempClass = tempClass.superclass
            if (tempClass == Base::class.java) {
                declaredFields.addAll(tempClass.declaredFields)
                break
            } else if (tempClass == Object::class.java) {
                break
            }
        }
        // 获取私有成员变量
        
        for (field in declaredFields) {
            if (field.getAnnotation(CreateUser::class.java) != null) {
                if (SqlCommandType.INSERT == sqlCommandType) { // insert 语句插入 createUser
                    val user = getSessionUser()
                    user?.apply {
                        field.isAccessible = true
                        field.set(parameter, user.id)
                    }
                }
            }
            
            if (field.getAnnotation(UpdateUser::class.java) != null) { // insert 或 update 语句插入 updateUser
                if (SqlCommandType.INSERT == sqlCommandType || SqlCommandType.UPDATE == sqlCommandType) {
                    val user = getSessionUser()
                    user?.apply {
                        field.isAccessible = true
                        field.set(parameter, user.id)
                    }
                }
            }
            if (field.getAnnotation(PrimaryKey::class.java) != null) { // insert 语句插入 主键
                field.isAccessible = true
                val id = field.get(parameter)
                if (id is String) {
                    if (id.isEmpty()) {
                        if (SqlCommandType.INSERT == sqlCommandType) {
                            field.set(parameter, UUIDUtil.uuid)
                        }
                    }
                }
            }
        }
        
        return invocation.proceed()
    }
    
    override fun setProperties(properties: Properties?) {
    
    }
    
    override fun plugin(target: Any?): Any {
        return Plugin.wrap(target, this)
    }
    
}

@Target(
    AnnotationTarget.FIELD
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class PrimaryKey

@Target(
    AnnotationTarget.FIELD
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class CreateUser

@Target(
    AnnotationTarget.FIELD
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class UpdateUser
