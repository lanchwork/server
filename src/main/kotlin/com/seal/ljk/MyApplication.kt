package com.seal.ljk

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling


@MapperScan("com.seal.ljk.dao")
@EnableScheduling
@SpringBootApplication
class MyApplication

fun main(args: Array<String>) {
    SpringApplication.run(MyApplication::class.java, *args)
}
