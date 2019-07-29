package com.java.base.impatient.ch03.sec02;

interface Identified {
    /** Ĭ�ϵĽӿڷ���*/
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

    /** implement����interface��default�����ĳ�ͻ���
     * 1. �Լ�����ʵ��
     * 2. ѡ�� ���ĸ��ӿڵ�Ĭ�Ϸ���
     */
    public int getId() { return Identified.super.getId(); }
}