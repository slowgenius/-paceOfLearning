package com.slowgenius.designPatterns.creationalPatterns.factoryPattern.demo;

/**
 * @author slowgenius
 * @date 2019/12/14 18:58
 * @description
 */
public class Waiter {

    public static void main(String[] args) {
        Chef chef = new TheChineseFeastChef();

        Chef chef1 = new MapoBeancurdChef();
        Menu menu = chef.cookDishes();
        MapoBeancurd mapoBeancurd = (MapoBeancurd)chef1.cookDishes();
        menu.taste();
        mapoBeancurd.taste();
        System.out.println(args);

    }

}
