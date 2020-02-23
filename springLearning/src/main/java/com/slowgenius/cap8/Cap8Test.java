package com.slowgenius.cap8;

import com.slowgenius.cap8.config.Cap8MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author slowgenius
 * @date 2/22/2020 7:45 PM
 * @description
 */
public class Cap8Test {

    @Test
    public void test() {
        AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(Cap8MainConfig.class);

        for (String beanDefinitionName : anno.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        Object bean = anno.getBean("bird");
        System.out.println(bean);
    }
}
