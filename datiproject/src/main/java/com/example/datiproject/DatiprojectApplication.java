package com.example.datiproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.datiproject.dao")
public class DatiprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatiprojectApplication.class, args);
    }
}
