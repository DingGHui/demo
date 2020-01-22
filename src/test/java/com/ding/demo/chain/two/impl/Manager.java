package com.ding.demo.chain.two.impl;

import com.ding.demo.chain.two.Handler;
import com.ding.demo.chain.two.ILeave;

/**
 * 部门经理
 */
public class Manager extends Handler {
    public Manager() {
        super(Handler.NUM_THREE, Handler.NUM_SEVEN);
    }

    @Override
    public void handleLeave(ILeave leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("部门经理审批：同意。");
    }
}