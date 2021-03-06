package com.wuyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by xuwuyuan on 2017/7/18.
 */
@SpringBootApplication
public class CoffeeMateApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CoffeeMateApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CoffeeMateApplication.class, args);
    }
}
