package com.lucaswangdev;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 特别注意，启动的时候不要漏了这句
 * @MapperScan("com.lucaswangdev.mapper")
 */
@SpringBootApplication
@MapperScan("com.lucaswangdev.mapper")
public class MpApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MpApiApplication.class, args);
    }
}
