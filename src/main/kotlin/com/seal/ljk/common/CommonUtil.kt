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

fun success(data: Any? = null): ResVal {
    return ResValMsg(0, data, "操作成功")
}

fun error(msg: String?, code: Int = 1): ResVal {
    return ResValMsg(code = code, data = null, msg = msg)
}

inline fun <K, V> MutableMap<K, MutableList<V>>.getOrCreate(key: K): MutableList<V> {
    var list = this[key]
    if (list == null) {
        list = mutableListOf()
        this[key] = list
    }
    return list
}
