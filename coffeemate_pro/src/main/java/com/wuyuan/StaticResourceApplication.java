package com.wuyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by xuwuyuan on 2017/7/18.
 */
@ImportResource({"classpath:spring/applicationContext.xml"})
@SpringBootApplication
public class StaticResourceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StaticResourceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(StaticResourceApplication.class, args);
    }
}
