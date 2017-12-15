package com.example.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/12/15
 * Time: 下午5:29
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DService implements InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("DService postConstruct");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("DService preDestory");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DService destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DService afterPropertiesSet");
    }
}
