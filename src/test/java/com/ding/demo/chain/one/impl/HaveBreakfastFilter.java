package com.ding.demo.chain.one.impl;

import com.ding.demo.chain.one.AbstractPrepareFilter;
import com.ding.demo.chain.one.PreparationList;

public class HaveBreakfastFilter extends AbstractPrepareFilter {
    
    public HaveBreakfastFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isHaveBreakfast()) {
            System.out.println("吃早餐");
        }
        
    }
    
}