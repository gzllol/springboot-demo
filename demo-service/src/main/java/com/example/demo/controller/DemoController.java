package com.example.demo.controller;

import com.example.demo.ServiceB;
import com.example.demo.ServiceC;
import org.springframework.beans.factory.serviceloader.ServiceFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/hello")
    String home() {
        return "Hello World!\n";
    }

    @RequestMapping("/depTest")
    String depTest() {
        ServiceB serviceB = new ServiceB();
        serviceB.method1();
        ServiceC serviceC = new ServiceC();
        serviceC.method1();
        return "ok";
    }
}
