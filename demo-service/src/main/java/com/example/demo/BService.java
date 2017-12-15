package com.example.demo;

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
public class BService {

    public BService() {
        System.out.println("BService constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("BService postConstruct");
    }

}
