package com.slowgenius.operator;

/**
 * @author slowgenius
 * @date 2/14/2020 6:47 PM
 * @description
 */
public class demo {
    public static void main(String[] args) {
        and();
    }

    public static void and() {
        System.out.println(1 | 10);
        System.out.println(false | false | false);
        System.out.println(3 & 9);
    }
}
