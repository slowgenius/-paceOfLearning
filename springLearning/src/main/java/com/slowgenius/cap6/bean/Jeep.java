package com.slowgenius.cap6.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author slowgenius
 * @date 2/22/2020 5:47 PM
 * @description
 */
@Component
public class Jeep {

    public Jeep() {
    }

    @PostConstruct
    public void init() {
        System.out.println("jeep @PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("jeep @PreDestroy");
    }
}
