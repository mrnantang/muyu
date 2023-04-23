package com.test.muyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.test.muyu.model.dao")
public class MuyuApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuyuApplication.class, args);
    }

}
