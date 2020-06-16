package com.ding.demo.controller;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
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
@RequestMapping("/orther")
@CacheConfig(cacheNames = "orther")
public class OtherController {


    private int a = 0;

    private int c = 1;

    @GetMapping("/add/{addNumber}")
    @Cacheable(key = "#p0")
    @CacheEvict(allEntries = true)
    public String add(@PathVariable("addNumber") String addNumber) {
        Integer integer = Integer.valueOf(addNumber);
        a += integer;
        System.out.println("进来了");
        return a + "";
    }

    @GetMapping("/get/{time}")
    @Cacheable(cacheNames = "orther", key = "#p0")
    public String get(@PathVariable("time") String time) {
        System.out.println("进来了");
        if (time.equalsIgnoreCase("a")) {
            return a + "";
        }
        return c + "";
    }

    @GetMapping("/del/{path}")
    @CacheEvict(allEntries = true)
    public String del(@PathVariable("path") String path) {
        System.out.println("进来了");
        return path;
    }
}
