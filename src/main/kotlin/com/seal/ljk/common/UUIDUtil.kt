package com.seal.ljk.common

import java.util.UUID

/**
 * 生成UUID工具类
 */
object UUIDUtil {

    val uuid: String
        get() = UUID.randomUUID().toString().replace("-", "")
}


fun main(args: Array<String>) {
    println(UUIDUtil.uuid)
    println(UUIDUtil.uuid)
    println(UUIDUtil.uuid)
}