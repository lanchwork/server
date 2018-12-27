package com.seal.ljk.base

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.swagger2.mappers.SerializableParameterFactories.factory
import javax.servlet.MultipartConfigElement

/**
 * Created by chenjh on 2018/12/22.
 */
@Configuration
class InterceptorConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowCredentials(true)
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/")

        registry.addResourceHandler("/${StaticFileConfig.path}/**")
                .addResourceLocations("file:${StaticFileConfig.fileDir}")
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**")
    }

    @Bean
    fun authenticationInterceptor(): AuthenticationInterceptor {
        return AuthenticationInterceptor()
    }

    @Bean
    fun multipartConfigElement(): MultipartConfigElement {
        val factory = MultipartConfigFactory()
        // 设置文件大小限制 ,超出设置页面会抛出异常信息，
        // 这样在文件上传的地方就需要进行异常信息的处理了;
        factory.setMaxFileSize("256KB") // KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("512KB");
        // Sets the directory location where files will be stored.
        // factory.setLocation("路径地址")
        return factory.createMultipartConfig()
    }

}


@Component
@ConfigurationProperties("static-file")
object StaticFileConfig {

    @Value("\${static-file.file-dir}")
    lateinit var fileDir: String
    @Value("\${static-file.path}")
    lateinit var path: String

}
