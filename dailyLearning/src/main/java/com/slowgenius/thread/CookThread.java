package com.slowgenius.thread;

/**
 * @author slowgenius
 * @date 2/14/2020 2:57 PM
 * @description
 */
public class CookThread extends Thread {
    private Object o = new Object();

    @Override
    public void run() {
        synchronized (o) {
               /**
                *   如果当且仅当当前线程拥有某个具体对象的锁返回true
                */
            System.out.println(Thread.holdsLock(o));
        }
        System.out.println(Thread.holdsLock(o));
        cookSomeThing();

    }

    public synchronized void cookSomeThing() {
        System.out.println("i am cooking something");
    }
}
