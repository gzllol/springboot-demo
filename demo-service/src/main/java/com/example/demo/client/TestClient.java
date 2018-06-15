package com.example.demo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2018/5/4
 * Time: 上午10:13
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(value = "test", url = "127.0.0.1:8012", configuration = FooConfigration.class)
public interface TestClient {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    String test();

}
