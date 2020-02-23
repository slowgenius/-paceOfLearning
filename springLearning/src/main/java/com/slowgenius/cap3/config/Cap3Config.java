package com.slowgenius.cap3.config;

import com.slowgenius.cap1.Person;
import com.slowgenius.cap2.service.OrderService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author slowgenius
 * @date 2/21/2020 8:15 PM
 * @description 排除时用默认配置useDefaultFilters = true
 */

@Configuration
public class Cap3Config {


    /**
     * 懒加载主要针对单实例 : 容器启动的时候不加载,仅当第一次获取的时候才创建并初始化
     * 懒汉模式
     * 默认饿汉模式
     */
    @Lazy
    @Bean
    public Person person() {
        System.out.println("i am creating");
        return new Person("slowgenius", 25);
    }
}
