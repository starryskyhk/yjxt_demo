package com.wnsf.yjxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wnsf.yjxt.sys.mapper")
@SpringBootApplication
public class YjxtApplication {

    public static void main(String[] args) {
        SpringApplication.run(YjxtApplication.class, args);
    }

}
