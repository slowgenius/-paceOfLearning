package com.slowgenius.cap6.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author slowgenius
 * @date 2/22/2020 5:32 PM
 * @description
 */


public class Train implements InitializingBean, DisposableBean {

    public Train() {
        System.out.println("create train............");
    }


    /**
     * 销毁时调用
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("train destroy .................");
    }

    public void destroyMethod() {
        System.out.println("train destroy method");
    }

    public void initMethod() {
        System.out.println("train init method");
    }

    /**
     * 初始化完成时调用
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("train afterPropertiesSet");
    }
}
