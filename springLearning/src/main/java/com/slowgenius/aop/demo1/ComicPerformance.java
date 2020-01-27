package com.slowgenius.aop.demo1;

import org.springframework.stereotype.Component;

/**
 * @author slowgenius
 * @date 1/27/2020 3:00 PM
 * @description
 */
@Component
public class ComicPerformance implements Performance {

    @Override
    public void perform() {
        System.out.println("i am performing");
    }
}
