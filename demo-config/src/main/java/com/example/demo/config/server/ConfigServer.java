package com.example.demo.config.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Sprint Cloud Config Server
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/11/28
 * Time: 下午9:22
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer.class, args);
    }
}
