package com.seal.ljk.base

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by cjh on 2018/12/4.
 */
val <T : Any> T.logger: Logger
    get() = LoggerFactory.getLogger(this.javaClass)
    
