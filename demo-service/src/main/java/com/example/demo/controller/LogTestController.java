package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志测试
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/11/10
 * Time: 上午10:34
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class LogTestController {

    protected final static Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log")
    String log() {
        logger.info("Hello SpringBoot Logback!!");
        return "ok";
    }

}
