package com.seal.ljk.common

data class ResVal(
        val code: Int, // 0-success, 1-error
        val data: Any?
)