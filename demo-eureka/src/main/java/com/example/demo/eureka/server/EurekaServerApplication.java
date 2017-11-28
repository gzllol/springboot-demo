package com.example.demo.eureka.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/11/14
 * Time: 下午8:54
 * To change this template use File | Settings | File Templates.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
    public static void main(String[] args)
    {
        new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }
}
