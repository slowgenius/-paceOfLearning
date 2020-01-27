package com.slowgenius.designPatterns.creationalPatterns.simpleFactoryPattern.demo;

/**
 * @author com.slowgenius
 * @date 2019/12/14 13:37
 * @description
 */
public class Waiter {

    public Waiter() {
        System.out.println("i am a waiter");
    }

    public static void main(String[] args) {
        TheChineseFeast theChineseFeast = (TheChineseFeast)Chef.cookDishes("theChineseFeast");
        theChineseFeast.taste();
        System.out.println(theChineseFeast.price);

        MapoBeancurd mapoBeancurd = (MapoBeancurd) Chef.cookDishes("mapoBeancurd");
        mapoBeancurd.taste();
        System.out.println(mapoBeancurd.price);
    }
}
