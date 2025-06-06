package com.nfcsolutionsusa.basicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public String hello (){
        return "hello world";
    }

    @GetMapping("/secured")
    public String secured (){
        return "This is the secured api response";
    }
}

