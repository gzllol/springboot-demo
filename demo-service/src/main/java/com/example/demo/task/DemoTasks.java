package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoTasks {

    @Scheduled(fixedRate = 5000)
    public void doSomethingEvery5Seconds() {
        System.out.println("fixedRate 5sec task executed");
    }

    @Scheduled(fixedDelay = 3000)
    public void doSomethingAndSleep2Seconds() {
        System.out.println("fixedDelay 2sec task start");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fixedDelay 2sec task end");
    }

}
