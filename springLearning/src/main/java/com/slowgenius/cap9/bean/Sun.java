package com.slowgenius.cap9.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author slowgenius
 * @date 2/23/2020 4:52 PM
 * @description
 */
@Component
public class Sun {

    private Moon moon;

    private Star star;

    @Autowired
    public Sun(Star star) {
        System.out.println("sun star " + star);
        this.star = star;
    }

    public Sun() {
        System.out.println("construct Sun default");
    }

    public Moon getMoon() {
        return moon;
    }

    @Autowired
    public void setMoon(Moon moon) {
        System.out.println("set" + moon);
        this.moon = moon;
    }


    @Override
    public String toString() {
        return "Sun{" +
                "moon=" + moon +
                '}';
    }
}
