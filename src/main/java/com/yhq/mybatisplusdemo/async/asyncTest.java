package com.yhq.mybatisplusdemo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author: YHQ
 * @Date: 2020/6/26 13:38
 */
@Component
public class asyncTest {
    @Async
    public Future<String> test1() throws InterruptedException {
        long s = System.currentTimeMillis();

        Thread.sleep(10000);

        System.out.println(System.currentTimeMillis() - s);
        System.out.println("test1 end");

        return new AsyncResult<>((System.currentTimeMillis() - s)+"");
    }
    @Async
    public Future<String> test2() throws InterruptedException {
        long s = System.currentTimeMillis();

        Thread.sleep(10000);

        System.out.println(System.currentTimeMillis() - s);
        System.out.println("test2 end");
        return new AsyncResult<>((System.currentTimeMillis() - s)+"");

    }
    @Async
    public Future<String> test3() throws InterruptedException {
        long s = System.currentTimeMillis();

        Thread.sleep(10000);

        System.out.println(System.currentTimeMillis() - s);
        System.out.println("test3 end");
        return new AsyncResult<>((System.currentTimeMillis() - s)+"");

    }
}
