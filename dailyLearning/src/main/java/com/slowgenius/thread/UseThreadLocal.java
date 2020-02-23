package com.slowgenius.thread;

import java.io.Serializable;

/**
 * @author slowgenius
 * @date 2/20/2020 9:04 PM
 * @description
 */
public class UseThreadLocal {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public void startThreadArray() {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new TestThread(i));
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }


    public static class TestThread implements Runnable {
        int id;

        public TestThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":start");
            Integer s = threadLocal.get();//获取变量的值
            s = s + id;
            threadLocal.set(s);
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        UseThreadLocal u = new UseThreadLocal();
        u.startThreadArray();

    }
}
