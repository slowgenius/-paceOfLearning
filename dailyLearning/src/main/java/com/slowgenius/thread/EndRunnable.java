package com.slowgenius.thread;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author slowgenius
 * @date 2/20/2020 7:25 PM
 * @description
 */
public class EndRunnable implements Runnable{

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(threadName);
            System.out.println(threadName + " interrupt flag is " + Thread.currentThread().isInterrupted());
        }
        System.out.println(threadName + " interrupt flag is " + Thread.currentThread().isInterrupted());
        System.out.println(threadName + " interrupt flag is " + Thread.currentThread().interrupted());
        System.out.println(threadName + " interrupt flag is " + Thread.currentThread().isInterrupted());

    }

    public static void main(String[] args) throws InterruptedException {
        EndRunnable endRunnable = new EndRunnable();
        Thread endThread = new Thread(endRunnable, "endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();

    }
}
