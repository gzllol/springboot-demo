package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
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
//@DependsOn("BService")
public class AService {

    @Autowired
    private BService bService;

    public AService() {
        System.out.println("AService constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("AService postConstruct");
    }

}
