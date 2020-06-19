package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// http://localhost:8080/hello/sts
@RestController 
@RequestMapping("/hello")  
public class HelloController {
    @RequestMapping("/sts")
    public String helloworld(){  
        return "hellow spring";  
    }  
}