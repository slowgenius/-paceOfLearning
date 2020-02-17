package com.slowgenius.logicalStatement;

/**
 * @author slowgenius
 * @date 2/16/2020 12:10 PM
 * @description
 */
public class demo {
    /**
     * 跳出多层for循环
     */
    public static void jumpOutMangFor() {
        forx:
        for (int i = 0; i < 3; i++) {
            fora:
            for (int j = 0; j < 3; j++) {
                forb:
                for (int k = 0; k < 3; k++) {
                    forc:
                    System.out.println(i + "-" + j + "-" + k);
                    if (i == 1) {
                        break fora;
                    }
                }
            }


        }
    }

    /**
     * switch不能用long
     */

    public static void switchDemo() {
        int intNumber = 1;
        String str = "1111";
        switch (str) {
            case "1":
                System.out.println(1);
                break;
            case "2":
                System.out.println(2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + str);
        }

        switch (intNumber) {
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            default:
                System.out.println("nothing");
        }

        byte b = 'a';

        switch (b) {
            case 'a':
                System.out.println('a');
            case '1':
                System.out.println('1');

        }

        short s = 1;

        switch (s) {
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
        }

        long l = 1L;
        //不可以用long
//        switch (l) {
//
//        }
    }

    public static void main(String[] args) {
        jumpOutMangFor();
    }
}

