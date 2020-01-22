package com.ding.demo.chain.three.impl;

import com.ding.demo.chain.three.Prepare;

/**
 * @author ding
 * @date 2020/1/22
 */
public class BrushTeeth extends Prepare {

    public BrushTeeth() {
    }

    public BrushTeeth(Prepare nextPrepare) {
        super(nextPrepare);
    }

    @Override
    public void doPrepare() {
        System.out.println("刷牙");
    }
}
