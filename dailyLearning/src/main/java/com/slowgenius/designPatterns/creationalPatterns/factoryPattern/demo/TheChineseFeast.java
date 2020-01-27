package com.slowgenius.designPatterns.creationalPatterns.factoryPattern.demo;

/**
 * @author com.slowgenius
 * @date 2019/12/14 16:52
 * @description 满汉全席
 */
public class TheChineseFeast extends Menu {

    public TheChineseFeast() {
        super.price = 1.0;
    }

    public void taste() {
        System.out.println("nobody knows");
    }

    public void cook() {
        System.out.println("cooking theChineseFeast");
    }
}
