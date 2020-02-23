package com.slowgenius.thread;

/**
 * @author slowgenius
 * @date 2/20/2020 7:15 PM
 * @description 如何安全的中断线程
 */
public class EndThread extends Thread {

    private static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()) {
                System.out.println(threadName);
            }
            System.out.println(threadName + " interrupt flag is " + isInterrupted());

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }

}
