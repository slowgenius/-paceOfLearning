package com.slowgenius.cap2.config;

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
@ComponentScan(value = "com.slowgenius.cap2.*", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = OrderService.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = CustomFilter.class)
}, useDefaultFilters = false)
public class Cap2Config {

    //可以配置单例还是多例
    //prototype 多实例 ioc启动时不创建实例,在调用的时候才创建实例
    //singleton 单实例 ioc启动时调用方法创建实例并放到ioc容器中
    //request 主要针对web应用,递交一次请求创建一次实例
    //session 同一个session创建一个实例
    @Scope("prototype")
    @Bean
    public Person person() {
        return new Person("slowgenius", 25);
    }
}
