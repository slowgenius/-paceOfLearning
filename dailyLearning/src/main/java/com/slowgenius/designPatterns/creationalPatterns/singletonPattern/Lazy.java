package com.slowgenius.designPatterns.creationalPatterns.singletonPattern;

/**
 * @author slowgenius
 * @date 2/16/2020 6:16 PM
 * @description
 */
public class Lazy {

    private Lazy() {

    }

    private static Lazy instance = null;

    public static Lazy getInstance() {
        if (instance == null) {
            instance = new Lazy();
        }
        return instance;
    }
}
