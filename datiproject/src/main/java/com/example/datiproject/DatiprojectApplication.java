package com.example.datiproject;

import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.swing.*;


@SpringBootApplication
@MapperScan("com.example.datiproject.dao")
public class DatiprojectApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(DatiprojectApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(DatiprojectApplication.class, args);
    }

}



