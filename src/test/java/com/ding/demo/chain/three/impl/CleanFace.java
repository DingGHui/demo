package com.ding.demo.chain.three.impl;

import com.ding.demo.chain.three.Prepare;

/**
 * @author ding
 * @date 2020/1/22
 */
public class CleanFace extends Prepare {
    public CleanFace() {
    }

    public CleanFace(Prepare nextPrepare) {
        super(nextPrepare);
    }

    @Override
    public void doPrepare() {
        System.out.println("洗脸");
    }
}
