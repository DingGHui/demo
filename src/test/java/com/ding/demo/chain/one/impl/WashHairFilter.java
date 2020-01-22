package com.ding.demo.chain.one.impl;

import com.ding.demo.chain.one.AbstractPrepareFilter;
import com.ding.demo.chain.one.PreparationList;

public class WashHairFilter extends AbstractPrepareFilter {
    
    public WashHairFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isWashHair()) {
            System.out.println("洗头");
        }
        
    }
    
}