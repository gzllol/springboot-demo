package com.example.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/12/15
 * Time: 下午4:28
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CService implements ApplicationListener<ContextRefreshedEvent> {

    public CService() {
        System.out.println("CService constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("CService postConstruct");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("onContextRefreshedEvent");
    }
}
