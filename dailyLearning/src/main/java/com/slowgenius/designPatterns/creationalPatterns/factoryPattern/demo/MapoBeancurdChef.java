package com.slowgenius.designPatterns.creationalPatterns.factoryPattern.demo;

/**
 * @author com.slowgenius
 * @date 2019/12/14 18:52
 * @description
 */
public class MapoBeancurdChef extends Chef{

    public Menu cookDishes() {
        return new MapoBeancurd();
    }

}
