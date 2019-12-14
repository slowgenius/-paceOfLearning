package com.slowgenius.designPatterns.factoryPattern;

import com.slowgenius.designPatterns.factoryPattern.Menu;

/**
 * @author slowgenius
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
