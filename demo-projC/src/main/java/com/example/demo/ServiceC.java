package com.example.demo;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/11/3
 * Time: 上午11:03
 * To change this template use File | Settings | File Templates.
 */
public class ServiceC {

    public void method1() {
        System.out.println("this is ServiceC method1 v1.0.0");
        ServiceA serviceA = new ServiceA();
        serviceA.method3();
        serviceA.method2();
    }


}
