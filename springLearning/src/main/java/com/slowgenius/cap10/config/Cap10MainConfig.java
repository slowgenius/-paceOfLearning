package com.slowgenius.cap10.config;

import com.slowgenius.cap10.aop.Calculator;
import com.slowgenius.cap10.aop.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author slowgenius
 * @date 2/23/2020 6:00 PM
 * @description
 */
@Configuration
@EnableAspectJAutoProxy
public class Cap10MainConfig {
    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
