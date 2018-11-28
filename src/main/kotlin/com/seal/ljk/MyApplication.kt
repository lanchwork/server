package com.seal.ljk

import com.github.pagehelper.PageHelper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling
import java.util.*


@MapperScan("com.seal.ljk.dao","com.seal.ljk.service")
@EnableScheduling
@SpringBootApplication
open class MyApplication()

fun main(args: Array<String>) {
    SpringApplication.run(MyApplication::class.java, *args)

    @Bean
    fun pageHelper() : PageHelper {
        val pageHelper = PageHelper();
        val p = Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}