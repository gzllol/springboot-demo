package com.example.demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/11/14
 * Time: 下午8:54
 * To change this template use File | Settings | File Templates.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args)
    {
//        System.setProperty("druid.logType", "log4j2");//启用log4j2
        //		System.setProperty("spring.config.location",
        //				"classpath:druid.properties,classpath:dubbo.properties,classpath:redis.properties"); //设置配置文件
        SpringApplication.run(EurekaApplication.class, args);
    }
}
