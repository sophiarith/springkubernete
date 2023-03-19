package com.kshrd.registration.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer {

    //Be careful: "src/main/resources/images" error without slash;
    //String serverPath = "/app/src/main/resources/images/";
    String serverPath = "/src/main/resources/images/";
//    String serverPath = "/home/leangsengk90/images/";

    @Value("${file.upload.server.path}")
    private String server;

    @Value("${file.upload.client.path}")
    private String client;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        WebMvcConfigurer.super.addResourceHandlers(registry);

        //change resource path "src/main/resources/images/" to "/images/**";
        registry.addResourceHandler(client).addResourceLocations("file:" + serverPath);
        //file: (type of path from where?) is root directory from project file: src/main/resources/images/

    }
}
