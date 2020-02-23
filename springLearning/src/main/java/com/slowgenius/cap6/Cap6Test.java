package com.slowgenius.cap6;

import com.slowgenius.cap6.config.Cap6MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author slowgenius
 * @date 2/22/2020 4:17 PM
 * @description
 */
public class Cap6Test {

    @Test
    public void test() {
        AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(Cap6MainConfig.class);
        System.out.println("create all finished");
        anno.close();
    }
}
