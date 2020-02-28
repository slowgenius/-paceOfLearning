package com.slowgenius.myDemo.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author slowgenius
 * @date 2/27/2020 11:14 PM
 * @description
 */
@Component
public class MyBeanFactory implements FactoryBean<MyBeanFactory> {

    public MyBeanFactory() {
        System.out.println("i am in myBeanFactory constructor");
    }
    @Override
    public MyBeanFactory getObject() throws Exception {
        System.out.println("i am in myBeanFactory getObject");
        return new MyBeanFactory();
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("i am in myBeanFactory getObjectType");
        return MyBeanFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
