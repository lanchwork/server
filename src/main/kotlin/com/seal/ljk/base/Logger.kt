package com.seal.ljk.base

import com.seal.ljk.MyApplication
import org.slf4j.LoggerFactory

/**
 * Created by cjh on 2018/12/4.
 */
fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)

val logger = LoggerFactory.getLogger(MyApplication::class.java)
    
