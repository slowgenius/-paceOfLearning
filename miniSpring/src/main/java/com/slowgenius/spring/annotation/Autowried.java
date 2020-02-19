package com.slowgenius.spring.annotation;

import java.lang.annotation.*;

/**
 * @author slowgenius
 * @date 2/19/2020 10:00 PM
 * @description
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowried {
    String value() default "";

}
