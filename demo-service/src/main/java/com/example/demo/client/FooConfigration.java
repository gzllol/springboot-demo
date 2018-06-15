package com.example.demo.client;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2018/5/4
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
//@Configuration
public class FooConfigration {

    @Bean
    Request.Options feignOptions() {
        return new Request.Options(/**connectTimeoutMillis**/1 * 1000, /** readTimeoutMillis **/1 * 1000);
    }
}
