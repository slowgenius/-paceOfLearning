package com.slowgenius.cap9.bean;

import org.springframework.stereotype.Component;

/**
 * @author slowgenius
 * @date 2/23/2020 4:47 PM
 * @description
 */

@Component
public class Moon {


    public Moon() {
        System.out.println("constructing moon..........");
    }


    public void init() {
        System.out.println("moon init...........");
    }


    public void destroy() {
        System.out.println("");
    }



}
