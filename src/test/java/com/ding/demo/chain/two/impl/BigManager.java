package com.ding.demo.chain.two.impl;

import com.ding.demo.chain.two.Handler;
import com.ding.demo.chain.two.ILeave;

/**
 * 总经理
 */
public class BigManager extends Handler {
    public BigManager() {
        super(Handler.NUM_SEVEN);
    }

    @Override
    public void handleLeave(ILeave leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("总经理审批：同意。");
    }


}