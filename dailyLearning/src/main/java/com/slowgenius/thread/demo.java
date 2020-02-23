package com.slowgenius.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

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


    /**
    * 打印线程个数
    */
    public static void showThreadCount() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        int count = threadMXBean.getThreadCount();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadName());
        }
        System.out.println(count);
    }

    private static class UseRun implements Runnable {

        @Override
        public void run() {
            System.out.println("i am in runnable");
        }
    }

    private static class UseCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("i am in callable");
            return "callable";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        showThreadCount();
        UseRun useRun = new UseRun();
        useRun.run();
        new Thread(useRun).start();
        UseCallable useCallable = new UseCallable();
        FutureTask<String> futureTask = new FutureTask<>(useCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
