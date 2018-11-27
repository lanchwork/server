package com.seal.ljk.common

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
@ComponentScan("com.seal.ljk.controller")
open class SwConfig {
    @Bean
    open fun createRestApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.seal.ljk.controller"))
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(true)
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder().title("API接口文档")
                .description("API Interface Docs.")
                .termsOfServiceUrl("")
                .version("1.0")
                .build()
    }

}
