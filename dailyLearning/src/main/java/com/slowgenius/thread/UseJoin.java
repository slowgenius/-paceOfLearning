package com.slowgenius.thread;

/**
 * @author slowgenius
 * @date 2/21/2020 3:53 PM
 * @description
 */
public class UseJoin {

    private static class JumpQueue implements Runnable {

        private Thread thread;

        public JumpQueue(Thread thread) {
            this.thread = thread;
        }
        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminated");
        }
    }

    public static void main(String[] args) {

        Thread previous = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new JumpQueue(previous), String.valueOf(i));
            System.out.println(previous.getName() + " jump a queue the thread : " + thread.getName());
            thread.start();
            previous = thread;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " terminated ");

    }

}
