package com.slowgenius.thread;

/**
 * @author slowgenius
 * @date 2/20/2020 8:17 PM
 * @description 直接用run可能会被当作普通方法调用,run被谁调用就是谁的
 */
public class RunAndStart extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new RunAndStart();
        thread.setName("runAndStart");
        thread.run();
        thread.start();
    }
}
