package com.wnsf.yjxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@MapperScan("com.wnsf.yjxt.sys.mapper")
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching(proxyTargetClass = true)//强制使用cglib代理
public class YjxtApplication {

    public static void main(String[] args) {
        SpringApplication.run(YjxtApplication.class, args);
    }

}
