package com.ag;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.ag.mapper")
public class EstateManagementApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(EstateManagementApplication1.class, args);
        log.warn("http://localhost/index.html");
    }

}
