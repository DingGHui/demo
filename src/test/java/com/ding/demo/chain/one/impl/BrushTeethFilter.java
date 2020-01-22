package com.ding.demo.chain.one.impl;

import com.ding.demo.chain.one.AbstractPrepareFilter;
import com.ding.demo.chain.one.PreparationList;

/**
 * @author ding
 * @date 2020/1/22
 */
public class BrushTeethFilter extends AbstractPrepareFilter {

    public BrushTeethFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if(preparationList.isBrushTeeth()){
            System.out.println("刷牙");
        }
    }
}
