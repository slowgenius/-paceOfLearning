package com.slowgenius.thread;

/**
 * @author slowgenius
 * @date 2/14/2020 2:55 PM
 * @description
 */
public class demo {

    private static Object CookThread = new CookThread();

    /**
     * 创建线程方式1:继承Thread 重写run方法
     * */
    public static void cookDemo() {
        Thread cook = new CookThread();
        cook.setName("cook");
        cook.run();
    }

    /**
     * 创建线程方式2:实现runnable接口
     */
    public static void playDemo() {
        PlayThread playThread = new PlayThread();
        playThread.run();
    }


    public static void main(String[] args) {
        cookDemo();
//        playDemo();

    }
}
