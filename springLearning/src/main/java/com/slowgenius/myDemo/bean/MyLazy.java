package com.slowgenius.myDemo.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author slowgenius
 * @date 2/27/2020 11:00 PM
 * @description
 */
@Lazy
@Component
public class MyLazy {
    public MyLazy() {
        System.out.println("i am constructing myLazy");
    }
}
