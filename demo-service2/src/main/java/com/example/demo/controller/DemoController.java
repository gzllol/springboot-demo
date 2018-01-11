package com.example.demo.controller;

import com.example.demo.remote.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    ServiceClient serviceClient;

    @RequestMapping("/add")
    int add(@RequestParam("a") int a, @RequestParam("b") int b) {
        return serviceClient.add(a, b);
    }

}
