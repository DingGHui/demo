package com.ding.demo.chain.two.impl;

import com.ding.demo.chain.two.Handler;
import com.ding.demo.chain.two.ILeave;

/**
 * 小组长
 */
public class GroupLeader extends Handler {
    public GroupLeader() {
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    public void handleLeave(ILeave leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("小组长审批：同意。");
    }
}