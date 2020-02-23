package com.slowgenius.cap5.config;

import com.slowgenius.cap5.bean.Monkey;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author slowgenius
 * @date 2/22/2020 2:00 PM
 * @description
 */
public class MyFactoryBean implements FactoryBean<Monkey> {

    @Override
    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    @Override
    public Class<?> getObjectType() {
        return Monkey.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
