package com.ding.demo.chain.three.impl;

import com.ding.demo.chain.three.Prepare;

/**
 * @author ding
 * @date 2020/1/22
 */
public class BreakFast extends Prepare {
    @Override
    public void doPrepare() {
        System.out.println("吃早饭");
    }
}
