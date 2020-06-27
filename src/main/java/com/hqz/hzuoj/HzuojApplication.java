package com.hqz.hzuoj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hqz.hzuoj.mapper")
public class HzuojApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzuojApplication.class, args);
    }

}
