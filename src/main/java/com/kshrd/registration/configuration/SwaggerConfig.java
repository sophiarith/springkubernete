package com.kshrd.registration.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;


// this is the configuration for your swagger

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .ignoredParameterTypes(AuthenticationPrincipal.class)
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kshrd.registration")) // with this we can specific why package to the api for the project.
                .paths(PathSelectors.any())// block the certain paths ....
                .build();
    }



    // Adding information to you swagger
    private ApiInfo apiInfo(){
        return new ApiInfo(
                "KSHRD REGISTRATION",
                "Online registration platform for entrance exam at KSHRD Center",
                "1.0",
                "https://kshrd.com.kh/about-us",
                new Contact("KSHRD REGISTRATION", "https://register.kshrd.com.kh","leangsengk90@gmail.com")//your name, url , email
                ,"KSHRD License",
                "https://kshrd.com.kh",
                Collections.emptyList()
        );


    }
    private ApiKey apiKey(){    return new ApiKey("JWT","Authorization","header");  }

    // Actually we have our default configuration for the swagger , but since we are working with the JWT
    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();

    }
    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global","accessEverything");
        AuthorizationScope[] authorizationScopes= new AuthorizationScope[1];
        authorizationScopes[0]=authorizationScope;

        logger.error("Authentication Scope : ->{}",authorizationScope.getScope());
        logger.error("Authentication Scope : ->{}",authorizationScope.getDescription());

        return Collections.singletonList(new SecurityReference("JWT",authorizationScopes));



    }

}

