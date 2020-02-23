package com.slowgenius.thread;

/**
 * @author slowgenius
 * @date 2/20/2020 7:36 PM
 * @description
 */
public class HasInterruptException extends Thread {

    private static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                    interrupt();
                }
                System.out.println(threadName);
            }
            System.out.println(threadName + " interrupt flag is " + isInterrupted());

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(5);
        System.out.println(1);
        endThread.interrupt();
    }
}
