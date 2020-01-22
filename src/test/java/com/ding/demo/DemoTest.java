package com.ding.demo;

import com.ding.demo.chain.one.*;
import com.ding.demo.chain.one.impl.BrushTeethFilter;
import com.ding.demo.chain.one.impl.HaveBreakfastFilter;
import com.ding.demo.chain.one.impl.WashFaceFilter;
import com.ding.demo.chain.one.impl.WashHairFilter;
import com.ding.demo.chain.three.Prepare;
import com.ding.demo.chain.three.impl.BreakFast;
import com.ding.demo.chain.three.impl.BrushTeeth;
import com.ding.demo.chain.three.impl.CleanFace;
import com.ding.demo.chain.two.Handler;
import com.ding.demo.chain.two.IHandler;
import com.ding.demo.chain.two.ILeave;
import com.ding.demo.chain.two.impl.BigManager;
import com.ding.demo.chain.two.impl.GroupLeader;
import com.ding.demo.chain.two.impl.Leave;
import com.ding.demo.chain.two.impl.Manager;
import org.junit.jupiter.api.Test;

/**
 * @author ding
 * @date 2020/1/22
 */
public class DemoTest {
    @Test
    public void testResponsibility() {
        PreparationList preparationList = new PreparationList();
        preparationList.setWashFace(true);
        preparationList.setWashHair(false);
        preparationList.setHaveBreakfast(true);
        preparationList.setBrushTeeth(true);

        Study study = new Study();

        AbstractPrepareFilter haveBreakfastFilter = new HaveBreakfastFilter(null);
        AbstractPrepareFilter washFaceFilter = new WashFaceFilter(haveBreakfastFilter);
        AbstractPrepareFilter washHairFilter = new WashHairFilter(washFaceFilter);
        AbstractPrepareFilter brushTeethFilter = new BrushTeethFilter(washHairFilter);


        brushTeethFilter.doFilter(preparationList, study);
    }

    /**
     * 后来才知道，3天以下的假小组长签字即可，
     * 3-7天的假需要小组长和部门经理签字，
     * 7以上的假小组长和部门经理签完字后还需要总经理签字。
     */
    @Test
    public void responsibilityTwoTest() {
        //请假条来一张
        ILeave leave = new Leave("小花", 5, "身体不适");

        Handler groupLeader = new GroupLeader();
        Handler manager = new Manager();
        Handler bigManager = new BigManager();

        groupLeader.setNextHandler(manager);
        manager.setNextHandler(bigManager);

        groupLeader.submit(leave);
    }

    @Test
    public void responsibilityThreeTest(){
        Prepare brushTeeth = new BrushTeeth();
        Prepare cleanFace = new CleanFace();
        Prepare breakFast = new BreakFast();

        brushTeeth.setNextPrepare(cleanFace);
        cleanFace.setNextPrepare(breakFast);

        brushTeeth.start();
    }
}
