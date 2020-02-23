package com.slowgenius.cap4;

import com.slowgenius.cap4.config.Cap4Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author slowgenius
 * @date 2/22/2020 11:18 AM
 * @description
 */
public class Cap4Test {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(Cap4Config.class);

        System.out.println("IOC容器构建完成");

    }
}
