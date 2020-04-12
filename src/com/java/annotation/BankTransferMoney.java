package com.java.annotation;

import java.lang.annotation.*;

/**�����޶�ע��*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BankTransferMoney {
    double maxMoney() default 10000;
}
