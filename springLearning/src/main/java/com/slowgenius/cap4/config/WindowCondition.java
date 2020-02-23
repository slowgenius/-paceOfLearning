package com.slowgenius.cap4.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author slowgenius
 * @date 2/22/2020 11:25 AM
 * @description
 */
public class WindowCondition implements Condition {

    /**
     * @param context  判断可以使用的上下文
     * @param metadata 注解的信息
     * @return
     * @description
     * @date 2/22/2020 11:28 AM
     * @author slowgenius
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取IOC正在使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取当前环境信息
        Environment environment = context.getEnvironment();
        String name = environment.getProperty("os.name");
        System.out.println(name);
        System.out.println(environment);
        if (name.contains("Windows")) {
            return true;
        }
        return false;
    }
}
