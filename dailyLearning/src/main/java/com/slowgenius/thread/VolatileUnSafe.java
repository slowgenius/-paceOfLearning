package com.slowgenius.thread;

/**
 * @author slowgenius
 * @date 2/20/2020 8:48 PM
 * @description
 */
public class VolatileUnSafe implements Runnable {

    private Integer a = 0;
    @Override
    public void run() {
        synchronized (a) {
            a = a + 2;
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "===========" + a);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = a + 2;
            System.out.println(threadName + "===========" + a);
        }



    }

    public static void main(String[] args) {
        VolatileUnSafe volatileUnSafe = new VolatileUnSafe();

        Thread t1 = new Thread(volatileUnSafe, "t1");
        Thread t2 = new Thread(volatileUnSafe, "t2");
        Thread t3 = new Thread(volatileUnSafe, "t3");
        Thread t4 = new Thread(volatileUnSafe, "t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
