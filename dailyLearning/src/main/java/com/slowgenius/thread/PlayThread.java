package com.slowgenius.thread;

/**
 * @author slowgenius
 * @date 2/14/2020 2:58 PM
 * @description
 */
public class PlayThread implements Runnable {

    @Override
    public void run() {
        System.out.println("i am playing");
    }
}
