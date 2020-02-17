package com.slowgenius.designPatterns.creationalPatterns.singletonPattern;

/**
 * @author slowgenius
 * @date 2/16/2020 6:14 PM
 * @description 饿汉模式
 */
public class Eager {

    private Eager() {

    }

    private static Eager instance = new Eager();

    public static Eager getInstance() {
        return instance;
    }
}

