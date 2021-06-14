package com.rasMainServer.raserver.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.service.ApiInfo
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class Swagger2Config {

    private fun apiInfo(): ApiInfo? {
        return ApiInfoBuilder()
            .title("Demo")
            .description("API EXAMPLE")
            .build()
    }

    @Bean
    fun commonApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .groupName("example")
            .apiInfo(apiInfo())
            .select()
            .apis(
                RequestHandlerSelectors
                    .basePackage("com.rasMainServer.raserver.controller")
            )
            .paths(PathSelectors.ant("/api/**"))
            .build()
    }


}