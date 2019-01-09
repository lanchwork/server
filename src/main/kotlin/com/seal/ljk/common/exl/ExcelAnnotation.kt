package com.seal.ljk.common.exl


import java.lang.annotation.*


@Documented
@Inherited
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@Target(AnnotationTarget.FIELD)
internal annotation class ExcelAnnotation(
        /**
         * 与excel标题头对应
         */
        val exportName: String,
        /**
         * 转换格式, 如时间类型 yyyy-MM-dd HH:mm:ss
         */
        val pattern: String = "",
        /**
         * 在excel中位置
         */
        val order: Int = 0)
