package com.slowgenius.thread;

/**
 * @author slowgenius
 * @date 2/20/2020 8:27 PM
 * @description
 */
public class DaemonThread extends Thread {

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                System.out.println(Thread.currentThread().getName());
            }finally {
                System.out.println("========finally============");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new DaemonThread();
        //thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();


    }
}
