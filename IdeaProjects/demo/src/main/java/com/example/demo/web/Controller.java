package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class Controller {

    @RequestMapping("/user")
    public String user(){
        return "hello";
    }
}
