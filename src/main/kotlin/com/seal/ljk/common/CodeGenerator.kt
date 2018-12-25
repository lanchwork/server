package com.seal.ljk.common

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException
import com.baomidou.mybatisplus.core.toolkit.StringPool
import com.baomidou.mybatisplus.core.toolkit.StringUtils
import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.InjectionConfig
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.po.TableInfo
import com.baomidou.mybatisplus.generator.config.rules.DateType
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine

import java.util.ArrayList
import java.util.Scanner

/**
 * Created by chenjh on 2018/12/24.
 */
object CodeGenerator {

    fun scanner(tip: String): String {
        val scanner = Scanner(System.`in`)
        val help = StringBuilder()
        help.append("请输入$tip：")
        println(help.toString())
        if (scanner.hasNext()) {
            val ipt = scanner.next()
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt
            }
        }
        throw MybatisPlusException("请输入正确的$tip！")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        // 代码生成器
        val mpg = AutoGenerator()

        // 全局配置
        val gc = GlobalConfig()
        gc.isKotlin = true
        gc.isFileOverride = true
        gc.isSwagger2 = true
        gc.dateType = DateType.ONLY_DATE

        val projectPath = System.getProperty("user.dir")

        gc.outputDir = "$projectPath/src/main/kotlin"
        gc.author = "chenjh"
        gc.isOpen = false
        gc.mapperName = "%sDao"
        mpg.globalConfig = gc

        // 数据源配置
        val dsc = DataSourceConfig()
        dsc.url =
                "jdbc:mysql://139.159.188.206:3306/seal-ljk?verifyServerCertificate=false&useSSL=false&requireSSL=false&characterEncoding=UTF-8"
        // dsc.setSchemaName("public");
        dsc.driverName = "com.mysql.jdbc.Driver"
        //        dsc.username = "root"
        //        dsc.password = ""
        dsc.username = "test"
        dsc.password = "Seal!@#2018"
        mpg.dataSource = dsc

        // 包配置
        val pc = PackageConfig()
        // pc.setModuleName(scanner("模块名"));
        pc.moduleName = "ljk"
        pc.parent = "com.seal"
        pc.entity = "model"
        pc.mapper = "dao"
        mpg.packageInfo = pc

        // 自定义配置
        val cfg = object : InjectionConfig() {
            override fun initMap() {
                // 自定义输出配置
                val focList = ArrayList<FileOutConfig>()
                // 自定义配置会被优先输出
                focList.add(object : FileOutConfig("/templates/mapper.xml.ftl") {
                    override fun outputFile(tableInfo: TableInfo): String {
                        // 自定义输出文件名
                        return projectPath + "/src/main/resources/mapper/" + tableInfo.entityName + "Mapper" + StringPool.DOT_XML
                    }
                })
                fileOutConfigList = focList
            }
        }


        mpg.cfg = cfg

        // 配置模板
        val templateConfig = TemplateConfig()
            .setEntityKt("/templates/model.kt")
            .setService("/templates/service.kt")
            .setServiceImpl("/templates/serviceImpl.kt")
            .setController("/templates/controller.kt")

        // 配置自定义输出模板
        // templateConfig.setEntity();
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.xml = null
        mpg.template = templateConfig

        // 策略配置
        val strategy = StrategyConfig()
        strategy.naming = NamingStrategy.underline_to_camel
        strategy.columnNaming = NamingStrategy.underline_to_camel
        strategy.superEntityClass = "com.seal.ljk.model.Base"
        strategy.superMapperClass = "com.seal.ljk.dao.BaseMapper"
        strategy.superServiceClass = "com.seal.ljk.service.IBaseService"
        strategy.superServiceImplClass = "com.seal.ljk.service.impl.BaseServiceImpl"
        strategy.isRestControllerStyle = true
        strategy.setInclude(scanner("表名"))
        strategy.setSuperEntityColumns("create_date", "create_user", "update_date", "update_user")
        strategy.isControllerMappingHyphenStyle = true
        mpg.strategy = strategy
        mpg.templateEngine = FreemarkerTemplateEngine()
        mpg.execute()
    }

}
