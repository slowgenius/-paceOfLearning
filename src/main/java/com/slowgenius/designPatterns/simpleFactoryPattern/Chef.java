package com.slowgenius.designPatterns.simpleFactoryPattern;

/**
 * @author slowgenius
 * @date 2019/12/14 16:46
 * @description 工厂类用于制作不同的菜
 */
public class Chef {

    public Chef() {
        System.out.println("i am a chef");
    }

    public static Menu cookDishes(String dishName) {
        if ("theChineseFeast".equals(dishName)) {
            return new TheChineseFeast();
        } else if ("mapoBeancurd".equals(dishName)) {
            return new MapoBeancurd();
        }

        return null;
    }
}
