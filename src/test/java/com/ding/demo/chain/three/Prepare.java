package com.ding.demo.chain.three;

import com.ding.demo.chain.one.Study;

/**
 * @author ding
 * @date 2020/1/22
 */
public abstract class Prepare {
    private Prepare nextPrepare;

    public Prepare() {
    }

    public Prepare(Prepare nextPrepare) {
        this.nextPrepare = nextPrepare;
    }

    public void setNextPrepare(Prepare nextPrepare) {
        this.nextPrepare = nextPrepare;
    }

    public void start() {
        this.doPrepare();
        if (nextPrepare != null) {
            nextPrepare.start();
        } else {
            new Study().study();
        }
    }

    public abstract void doPrepare();
}
