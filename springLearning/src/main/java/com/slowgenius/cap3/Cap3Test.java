package com.slowgenius.cap3;

import com.slowgenius.cap3.config.Cap3Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author slowgenius
 * @date 2/21/2020 8:22 PM
 * @description
 */
public class Cap3Test {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(Cap3Config.class);
        System.out.println("==================");
        anno.getBean("person");
    }
}
