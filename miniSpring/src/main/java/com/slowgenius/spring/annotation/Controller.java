package com.slowgenius.spring.annotation;

import java.lang.annotation.*;

/**
 * @author slowgenius
 * @date 2/19/2020 9:56 PM
 * @description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Controller {

    String value() default "";
}
