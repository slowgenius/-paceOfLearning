package com.slowgenius.cap6.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author slowgenius
 * @date 2/22/2020 7:19 PM
 * @description
 */
public class Plane implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    /**
     * applicationContext可以拿到
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
