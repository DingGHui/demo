package com.ding.demo.controller;

import com.ding.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private HelloService helloService;
    private static ThreadLocal s = new ThreadLocal();

    @GetMapping("/test")
    public String get(){
        System.out.println("c :" + Thread.currentThread());
        System.out.println("c :" + s.get());
        return "1";
    }
}
