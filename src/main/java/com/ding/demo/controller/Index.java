package com.ding.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ding
 * @date 2020/1/21
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class Index {
    @Value("${index.str:100}")
    private String str;
    @Value("${tes:p}")
    private String publicStr;
    @GetMapping("/apollo/str")
    public String get(){
        log.info(str);
        return str;
    }
    @GetMapping("/apollo/p")
    public String getP(){
        log.info(publicStr);
        return publicStr;
    }

}
