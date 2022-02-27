package com.xiaoze;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xiaoze.mapper")
@SpringBootApplication
public class GameWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameWebApplication.class, args);
    }

}
