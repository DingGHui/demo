package com.ding.demo;

/**
 * @author ding
 * @date 2020/8/28
 */
public class Andr implements Phone {
    @Override
    public void call() {
        System.out.println("安卓打电话");
    }

    @Override
    public void Ring() {
        System.out.println("安卓铃声");
    }
}
