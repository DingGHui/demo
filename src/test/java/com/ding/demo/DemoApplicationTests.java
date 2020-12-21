package com.ding.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

//@SpringBootTest
class DemoApplicationTests {

//    @Test
    void contextLoads() {

    }
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().getHour());
    }
}
