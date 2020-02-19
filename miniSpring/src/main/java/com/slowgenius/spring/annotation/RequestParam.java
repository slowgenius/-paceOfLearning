package com.slowgenius.spring.annotation;

import java.lang.annotation.*;

/**
 * @author slowgenius
 * @date 2/19/2020 10:01 PM
 * @description
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestParam {
    String value() default "";

}
