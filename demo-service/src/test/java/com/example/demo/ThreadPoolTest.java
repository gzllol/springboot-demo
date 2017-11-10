package com.example.demo;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/11/10
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
public class ThreadPoolTest {

    public void doSomethingWithTimeout()
    {
        final ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<String> call = new Callable<String>() {
            @Override
            public String call() throws Exception
            {
                Thread.sleep(1000);
                return "ok";
            }
        };
        String result = null;
        try
        {
            Future<String> future = executorService.submit(call);
            result = future.get(3000, TimeUnit.MILLISECONDS);
        }
        catch (TimeoutException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        executorService.shutdown();
    }

    @Test
    public void testDoSomething()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++)
        {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    doSomethingWithTimeout();
                }
            });
        }

        while (true)
        {

        }
    }



}
