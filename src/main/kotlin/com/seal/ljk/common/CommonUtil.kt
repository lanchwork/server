package com.seal.ljk.common

import com.seal.ljk.base.ParamException

/**
 * Created by chenjh on 2018/12/24.
 */
inline infix fun String.using(expr: Boolean) {
    if (!expr) throw ParamException(message = this)
}

fun checkParam(vararg params: String) {
    params.forEach {
        if (it.isEmpty()) throw ParamException()
    }
}
