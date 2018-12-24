package com.seal.ljk.base

import com.seal.ljk.common.setSessionUser
import com.seal.ljk.service.UserService
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by chenjh on 2018/12/22.
 */
@Target(
    AnnotationTarget.CLASS, AnnotationTarget.FUNCTION
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class IgnoreToken(val required: Boolean = true)

@Target(
    AnnotationTarget.CLASS, AnnotationTarget.FUNCTION
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class VerifyToken(val required: Boolean = true)

class AuthenticationInterceptor : HandlerInterceptor {
    
    lateinit var userService: UserService
    
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        // OPTIONS或不是映射到方法直接通过
        if (request.method == "OPTIONS" || handler !is HandlerMethod) {
            return true
        }
        
        // 从 http 请求头中取出 token
        val token = request.getHeader("token")
        
        val method = handler.method
        
        //检查是否有IgnoreToken注释，有则跳过认证
        if (method.isAnnotationPresent(IgnoreToken::class.java)) {
            val passToken = method.getAnnotation(IgnoreToken::class.java)
            if (passToken.required) {
                return true
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(VerifyToken::class.java)) {
            val userLoginToken = method.getAnnotation(VerifyToken::class.java)
            if (userLoginToken.required) {
                // 执行认证
                val user = userService.verifyUser(token)
                setSessionUser(user)
                return true
            }
        }
        return true
    }
}
