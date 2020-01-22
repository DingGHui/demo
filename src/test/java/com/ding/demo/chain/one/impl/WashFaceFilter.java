package com.ding.demo.chain.one.impl;

import com.ding.demo.chain.one.AbstractPrepareFilter;
import com.ding.demo.chain.one.PreparationList;

public class WashFaceFilter extends AbstractPrepareFilter {
    
    public WashFaceFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isWashFace()) {
            System.out.println("洗脸");
        }
        
    }
    
}