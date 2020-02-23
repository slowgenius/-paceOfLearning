package com.slowgenius.cap10.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author slowgenius
 * @date 2/23/2020 6:05 PM
 * @description 前置通知, 后置通知, 返回通知, 异常通知, 环绕通知
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public int com.slowgenius.cap10.aop.Calculator.*(..))")
    public void pointCut() {
        System.out.println("i am in pointCut");
    }

    @Before("pointCut()")
    public void logStart() {
        System.out.println("start");
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("end");
    }

    @AfterReturning("pointCut()")
    public void logReturn() {
        System.out.println("return");
    }

    @AfterThrowing("pointCut()")
    public void logException() {
        System.out.println("exception");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around start");
        Object result = joinPoint.proceed();
        System.out.println("around end");
        return result;
    }

}
