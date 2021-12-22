package com.example.probeersel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping(value = "/goodbye")
    public String sayGoodbye() {
        return "Goodbye, and have a nice day!";
    }

}
