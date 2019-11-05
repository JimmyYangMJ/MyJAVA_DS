package com.designPattern.BehaviorPattern.Strategy.impl;

import com.designPattern.BehaviorPattern.Strategy.AbstractCalculator;
import com.designPattern.BehaviorPattern.Strategy.ICalculator;

public class Plus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp, "\\+");
        return arrayInt[0] + arrayInt[1];
    }
}