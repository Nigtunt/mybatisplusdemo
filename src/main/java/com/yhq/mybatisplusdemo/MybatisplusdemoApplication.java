package com.yhq.mybatisplusdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MybatisplusdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusdemoApplication.class, args);

    }

}
