package com.slowgenius.cap9.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author slowgenius
 * @date 2/23/2020 5:24 PM
 * @description
 */
@Component
public class Star {

    public Star() {
        System.out.println("construct star");
    }

}
