package com.slowgenius.cap6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author slowgenius
 * @date 2/22/2020 5:55 PM
 * @description
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在init之前调用
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization " + beanName);
        return bean;
    }
}
