package com.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class MySwaggerConfig{

    @Value("${swagger_enable:true}")
    private boolean enable;

    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("action-swagger")
                        .description("swagger").termsOfServiceUrl("")
                        .version("1.0.0").build()).select()
                .apis(RequestHandlerSelectors.basePackage("com.test.web"))
                .paths(PathSelectors.any()).build();
    }

}
