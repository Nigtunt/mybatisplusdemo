package com.yhq.mybatisplusdemo;

import com.yhq.mybatisplusdemo.async.asyncTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

/**
 * @Author: YHQ
 * @Date: 2020/6/26 13:31
 */
@SpringBootTest
public class test {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> a= ()->{
            System.out.println(123);
            Thread.sleep(2000);
            System.out.println(123);
            return "success";
        };
        FutureTask<String > futureTask = new FutureTask<>(a);
        futureTask.run();
        System.out.println(futureTask.get());
    }

    @Autowired
    asyncTest test;

    @Test
    public void test() throws InterruptedException, ExecutionException {
        Future<String> stringFuture = test.test1();
        Future<String> stringFuture1 = test.test2();
        Future<String> stringFuture2 = test.test3();

        System.out.println(stringFuture.get());
        System.out.println(stringFuture1.get());
        System.out.println(stringFuture2.get());

    }
}
