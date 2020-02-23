package com.slowgenius.cap5;

import com.slowgenius.cap5.bean.Monkey;
import com.slowgenius.cap5.config.Cap5Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author slowgenius
 * @date 2/22/2020 11:18 AM
 * @description
 */
public class Cap5Test {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(Cap5Config.class);
        for (String beanDefinitionName : anno.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        };

        Object bean1 = anno.getBean("myFactoryBean");
        Object bean2 = anno.getBean("myFactoryBean");
        System.out.println(bean1 == bean2);
        System.out.println("IOC容器构建完成");

    }
}
