package com.slowgenius.cap8.config;

import com.slowgenius.cap8.bean.Bird;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author slowgenius
 * @date 2/22/2020 7:47 PM
 * @description
 */
@Configuration
@PropertySource(value = "classpath:/test.properties")
public class Cap8MainConfig {

    @Bean
    public Bird bird() {
        return new Bird();
    }

}
