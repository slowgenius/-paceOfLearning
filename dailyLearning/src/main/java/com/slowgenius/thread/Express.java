package com.slowgenius.thread;

/**
 * @author slowgenius
 * @date 2/21/2020 2:08 PM
 * @description
 */
public class Express {
    public final static String CITY = "ShangHai";

    private int km;

    private String site;

    public Express() {

    }

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public synchronized void changeKm() {
        this.km = 101;
        notifyAll();
    }

    public synchronized void changeSite() {
        this.site = "BeiJing";
        notifyAll();
    }

    public synchronized void waitKm() {
        while (this.km <= 100) {
            try {
                wait();
                System.out.println("check km thread[" + Thread.currentThread().getId() + "] is be notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the km is " + this.km);
    }

    public synchronized void waitSite() {
        while (CITY.equals(this.site)) {
            try {
                wait();
                System.out.println("check km thread[" + Thread.currentThread().getId() + "] is be notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the site is " + this.site);
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
