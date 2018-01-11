package com.example.demo.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2018/1/9
 * Time: 上午10:12
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(name = "demo-service")
public interface ServiceClient {

    @RequestMapping("/add")
    int add(@RequestParam("a") int a, @RequestParam("b") int b);

}
