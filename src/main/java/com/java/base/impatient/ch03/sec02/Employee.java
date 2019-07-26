package com.java.base.impatient.ch03.sec02;

interface Identified {
    /** 默认的接口方法*/
    default int getId() {
        return Math.abs(hashCode());
    }
}

interface Person {
    String getName();
    default int getId() { return 0; }
}

public class Employee implements Person, Identified {
    private String name;
    private double salary;
        
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;

    }

    /** implement两个interface的default方法的冲突解决
     * 1. 自己重新实现
     * 2. 选择 用哪个接口的默认方法
     */
    public int getId() { return Identified.super.getId(); }
}