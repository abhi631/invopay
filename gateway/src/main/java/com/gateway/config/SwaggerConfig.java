package com.gateway.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
@EnableAutoConfiguration
public class SwaggerConfig implements SwaggerResourcesProvider {

    public static final String AUTHORIZATION_HEADER= "Authorization";


    @Override
    public List get() {
        List resources = new ArrayList();
        resources.add(swaggerResource("zai-service", "/v2/api-docs", "2.0"));
        resources.add(swaggerResource("invopay-web-service", "/v2/api-docs", "2.0"));
        resources.add(swaggerResource("gateway-service", "/actuator", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .securitySchemes(Arrays.asList(apiKeys()))
//                .securityContexts(securityContexts())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

//    private List<SecurityContext> securityContexts(){
//        return Arrays.asList(SecurityContext.builder().securityReferences(securityReferences()).build());
//    }
//
//    private List<SecurityReference> securityReferences(){
//        AuthorizationScope socpes = new AuthorizationScope("global" , "accessEverything");
//        return  Arrays.asList(new SecurityReference("JWT" ,new AuthorizationScope[] { socpes } ));
//    }
//
//
//    private ApiKey apiKeys(){
//        return new ApiKey("JWT" , AUTHORIZATION_HEADER , "header");
//    }



}