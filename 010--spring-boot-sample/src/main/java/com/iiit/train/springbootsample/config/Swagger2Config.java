/**
 * Copyright (c) 2015
 * All rights reserved.
 *
 * Created on 2016-10-10
 */
package com.iiit.train.springbootsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiListingReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * Swagger配置信息
 *
 * @author rengang(rengang66@sina.com)
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        List<ApiListingReference> apiListingReferenceList = new ArrayList<>();
        apiListingReferenceList.add(new ApiListingReference("", "", 0));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.iiit.train.springcloud"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringCloud Demo Projects RESTful APIs")
                .description("http://api.iiit.train.com/")
                .termsOfServiceUrl("https://iiit.train.com/")
                .contact("rengang(rengang66@sina.com)")
                .version("1.0.0")
                .build();
    }
}
