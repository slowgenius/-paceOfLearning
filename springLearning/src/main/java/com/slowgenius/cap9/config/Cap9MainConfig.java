package com.slowgenius.cap9.config;

import com.slowgenius.cap9.dao.TestDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author slowgenius
 * @date 2/22/2020 8:08 PM
 * @description
 */
@Configuration
@ComponentScan({"com.slowgenius.cap9.*"})
public class Cap9MainConfig {

    /**
     * 这个要比扫描要早一些加载
     */
    @Bean
    public TestDao testDao() {
        return new TestDao();
    }

}
