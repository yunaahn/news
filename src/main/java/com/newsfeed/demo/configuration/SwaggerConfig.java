package com.newsfeed.demo.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "뉴스피드 API 명세서",
                description = "뉴스피드 과제 API 명세서",
                version = "v1")

)
public class SwaggerConfig {


}
