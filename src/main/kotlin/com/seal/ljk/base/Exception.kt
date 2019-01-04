package com.seal.ljk.base

import com.seal.ljk.common.ResVal
import com.seal.ljk.common.error
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

/**
 * Created by chenjh on 2018/12/22.
 */
open class SealException(override val message: String, var code: Int = 1) : RuntimeException(message)

class AuthException(override val message: String = "用户验证失败，请重新登录！") : SealException(message)

class ParamException(override val message: String = "存在参数为空或有误，请核对！") : SealException(message)


@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [Exception::class])
    @ResponseBody
    fun jsonErrorHandler(req: HttpServletRequest, e: Exception): ResponseEntity<ResVal> {
        logger.error("错误信息" + e.toString(), e)
        if (e is SealException) {
            return ResponseEntity.ok(error(e.message, e.code))
        }
        return ResponseEntity.ok(error(e.message ?: "接口异常。", 1))
    }

}
