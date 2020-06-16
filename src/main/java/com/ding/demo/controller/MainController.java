package com.ding.demo.controller;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ding
 * @date 2020/6/15
 */
@RestController
@RequestMapping("/main")
@CacheConfig(cacheNames = "maincontroller")
public class MainController {

    @GetMapping("/test1/{path}")
    @Cacheable(key = "#p0")
    public String test1(@PathVariable("path") String path) {
        System.out.println("进来了");
        return path;
    }

    @GetMapping("/test2/{path}")
    @Cacheable(cacheNames = "orther",key = "#p0")
    public String test2(@PathVariable("path") String path) {
        System.out.println("进来了");
        return path;
    }
}
