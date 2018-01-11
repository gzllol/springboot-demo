package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/hello")
    String home() {
        return "This is from demo-service\n";
    }

    @RequestMapping("/add")
    int add(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a + b;
    }

}