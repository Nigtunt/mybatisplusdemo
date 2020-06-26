package com.yhq.mybatisplusdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.time.Year;
import java.util.concurrent.Callable;

/**
 * @Author: YHQ
 * @Date: 2020/6/26 13:51
 */
@Controller
@RequestMapping
public class AsyncController {
    @RequestMapping("/async")
    @ResponseBody
    public DeferredResult<String> callable(){

        DeferredResult<String> result = new DeferredResult<>(3000L);

        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (""){
                System.out.println("success");
                result.setResult("success");

            }
        }).start();
        System.out.println("testtestestset");
        return result;
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
