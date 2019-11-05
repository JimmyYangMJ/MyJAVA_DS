package com.designPattern.BehaviorPattern.Strategy;

import com.designPattern.BehaviorPattern.Strategy.impl.Minus;

public class Test {

    public static void main(String[] args) {
        String exp = "8-2";
        ICalculator cal = new Minus();
        int result = cal.calculate(exp);
        System.out.println(exp + "=" + result);
    }
}
