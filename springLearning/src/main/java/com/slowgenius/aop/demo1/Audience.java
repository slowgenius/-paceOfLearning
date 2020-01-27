package com.slowgenius.aop.demo1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author slowgenius
 * @date 1/27/2020 2:40 PM
 * @description
 */

@Aspect
public class Audience {

    @Pointcut("execution(* com.slowgenius.aop.demo1.Performance.perform(..))")
    public void performance() {
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("i am taking seats");
    }

    @After("performance()")
    public void applause() {
        System.out.println("i am applausing");
    }
}
