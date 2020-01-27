package com.slowgenius.designPatterns.creationalPatterns.factoryPattern.demo;


/**
 * @author com.slowgenius
 * @date 2019/12/14 17:00
 * @description 麻婆豆腐
 */
public class MapoBeancurd extends Menu{

    public MapoBeancurd() {
        super.price = 2.0;
    }

    public void cook() {
        System.out.println("cooking mapoBeancurd");
    }

    public void taste() {
        System.out.println("so peppery");
    }
}
