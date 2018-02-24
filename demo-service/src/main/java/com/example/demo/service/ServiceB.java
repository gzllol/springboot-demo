package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2018/2/24
 * Time: 下午4:52
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ServiceB {
    @Autowired
    ServiceA serviceA;

    public int mulAdd(int a, int b, int c) {
        return serviceA.mul(a, b) + c;
    }
}
