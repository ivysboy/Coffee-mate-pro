package com.wuyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by xuwuyuan on 2017/7/18.
 */
@ImportResource({"classpath:spring/applicationContext.xml"})
@SpringBootApplication
public class CoffeeMateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeMateApplication.class, args);
    }
}
