package com.bridgelabz.quantitymeasurement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .paths(PathSelectors.regex("/measurements.*"))
                    .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.quantitymeasurement.controller"))
                    .build()
                    .apiInfo(apiInfo())
                    .consumes(Collections.singleton("application/json"))
                    .produces(Collections.singleton("application/json"))
                    .protocols(Collections.singleton("http"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Quantity Measurement Api")
                .description("Simple API for measurement conversions")
                .version("1.0")
                .contact(contact())
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

    private Contact contact() {
        return new Contact("Raghu Eswar", null, "raghueswar55@gmail.com");
    }

}
