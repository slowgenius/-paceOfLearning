package com.slowgenius.spring.annotation;

import java.lang.annotation.*;

/**
 * @author slowgenius
 * @date 2/19/2020 9:58 PM
 * @description
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {
    String value() default "";

}
