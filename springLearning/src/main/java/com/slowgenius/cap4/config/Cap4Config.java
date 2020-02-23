package com.slowgenius.cap4.config;

import com.slowgenius.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author slowgenius
 * @date 2/21/2020 8:15 PM
 * @description 排除时用默认配置useDefaultFilters = true
 */

@Configuration
public class Cap4Config {

    @Bean("person")
    public Person person() {
        System.out.println("给容器添加person.........");
        return new Person("person", 25);
    }
    @Conditional(WindowCondition.class)
    @Bean("lison")
    public Person lison() {
        System.out.println("给容器添加lison.........");

        return new Person("lison", 26);
    }
    @Bean("james")
    public Person james() {
        System.out.println("给容器添加james.........");

        return new Person("james", 64);
    }
}
