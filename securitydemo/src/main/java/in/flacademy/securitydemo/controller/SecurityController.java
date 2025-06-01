package in.flacademy.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {


    @GetMapping("/greet")
    public String greet() {
        return "Hello from Spring Security App";
    }
}
