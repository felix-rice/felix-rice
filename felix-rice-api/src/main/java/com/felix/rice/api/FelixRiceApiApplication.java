package com.felix.rice.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@MapperScan(basePackages = "com.felix.rice.*.mapper")
@ComponentScan(basePackages = "com.felix.rice.*")
@SpringBootApplication
public class FelixRiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FelixRiceApiApplication.class, args);
    }

}
