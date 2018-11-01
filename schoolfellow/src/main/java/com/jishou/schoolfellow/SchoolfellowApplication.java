package com.jishou.schoolfellow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@MapperScan("com.jishou.schoolfellow.Dao")
//@ComponentScan(basePackages = "com.example.demo0716101.controller")
public class SchoolfellowApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(SchoolfellowApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(SchoolfellowApplication.class, args);
    }
}
