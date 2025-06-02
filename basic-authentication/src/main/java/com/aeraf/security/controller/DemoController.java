package com.aeraf.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // open - permit all
    @GetMapping("/greetings")
    public String sayHello() {
        return "Hello World";
    }

    // secured - access to user
    @GetMapping("/secured")
    public String secured() {
        return "Secured Function Call";
    }

    // secured - access to admin
    @GetMapping("/admin-logs")
    public String adminLogs() {
        return "Admin Logs";
    }
}
