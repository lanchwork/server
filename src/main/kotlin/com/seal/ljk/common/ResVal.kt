package com.seal.ljk.common

open class ResVal(
        open val code: Int, // 0-success, 1-error
        open val data: Any?
)

data class ResValMsg(
        override val code: Int, // 0-success, 1-error
        override val data: Any? = null,
        val msg: String?
) : ResVal(code, data)
