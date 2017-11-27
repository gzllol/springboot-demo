package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/11/14
 * Time: 下午8:46
 * To change this template use File | Settings | File Templates.
 */
@FeignClient("gzl-test")
public interface DemoClient {


}
