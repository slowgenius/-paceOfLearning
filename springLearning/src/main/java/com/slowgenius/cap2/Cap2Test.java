package com.slowgenius.cap2;

import com.slowgenius.cap2.config.Cap2Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author slowgenius
 * @date 2/21/2020 8:22 PM
 * @description
 */
public class Cap2Test {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(Cap2Config.class);
        String[] names = anno.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("================");
        Object bean1 = anno.getBean("person");
        Object bean2 = anno.getBean("person");
        System.out.println(bean1 == bean2);
        names = anno.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
