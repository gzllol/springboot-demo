package com.example.demo.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/11/14
 * Time: 下午9:06
 * To change this template use File | Settings | File Templates.
 */
//@FeignClient(value = "gzl-test", url = "127.0.0.1:7009")
@FeignClient(value = "gzl-test")
public interface DemoClient {

    @RequestMapping("/hello")
    String home();

}
