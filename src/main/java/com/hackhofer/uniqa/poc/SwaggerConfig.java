package com.hackhofer.uniqa.poc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Config
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                                                      .paths(PathSelectors.any())
                                                      .apis(RequestHandlerSelectors.basePackage("com.hackhofer.uniqa.poc.json"))
                                                      .build()
                                                      .apiInfo(new ApiInfo(
                                                          "Uniqa POC API documentation",
                                                          "This API is a sample used to test RAD platform integratin features.",
                                                          "v0.1",
                                                          "Absolutely no warranty and liability",
                                                          new Contact("István Szoboszlai", "", "istvan.szoboszlai@hackhofer.com"),
                                                          "BSD-3 Clause License",
                                                          "https://opensource.org/licenses/BSD-3-Clause"))
                                                      .tags(new Tag("Uniqa Integration POC",
                                                                    "REST api for testing integration."));
    }
}
