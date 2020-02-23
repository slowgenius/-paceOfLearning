package com.slowgenius.cap6.config;

import com.slowgenius.cap6.bean.Bike;
import com.slowgenius.cap6.bean.Train;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author slowgenius
 * @date 2/22/2020 4:15 PM
 * @description
 */
@Configuration
@ComponentScan(value = "com.slowgenius.cap6.*")
public class Cap6MainConfig {

    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Bike bike() {
        return new Bike();
    }


    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Train train() {
        return new Train();
    }
}
