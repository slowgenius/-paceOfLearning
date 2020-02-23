package com.slowgenius.cap1.config;

import com.slowgenius.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author slowgenius
 * @date 2/21/2020 7:50 PM
 * @description
 */
@Configuration
public class MainConfig {

    @Bean
    public Person person1() {
        return new Person("james", 25);
    }

}
