package com.slowgenius.cap10;

import com.slowgenius.cap10.aop.Calculator;
import com.slowgenius.cap10.config.Cap10MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author slowgenius
 * @date 2/23/2020 4:53 PM
 * @description
 */
public class Cap10Test extends Calculator {

    @Test
    public void test() {
        AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(Cap10MainConfig.class);
        Calculator calculator = anno.getBean(Calculator.class);
        calculator.div(6, 3);

    }
}
