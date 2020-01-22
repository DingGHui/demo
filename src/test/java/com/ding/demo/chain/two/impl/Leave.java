package com.ding.demo.chain.two.impl;

import com.ding.demo.chain.two.ILeave;

/**
 * 假条实现类
 */
public class Leave implements ILeave {
    private String name;//姓名
    private int num;//请假天数
    private String content;//请假内容

    public Leave(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getContent() {
        return content;
    }
}