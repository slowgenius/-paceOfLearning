package com.slowgenius.cap5.config;

import com.slowgenius.cap1.Person;
import com.slowgenius.cap5.bean.Cat;
import com.slowgenius.cap5.bean.Dog;
import org.springframework.context.annotation.*;

import javax.xml.crypto.Data;

/**
 * @author slowgenius
 * @date 2/21/2020 8:15 PM
 * @description 排除时用默认配置useDefaultFilters = true
 */
@Import(value = {Dog.class, Cat.class, MyImportSelector.class, MyImportBeanDefinitionRegister.class})
@Configuration
public class Cap5Config {


    /**
     * 给容器注册组件的方式
     *
     * 1.@Bean 导入第三方类 比较简单
     * 2.@ComponentScan 通过扫描
     * 3.@Import 快速导入一个组件, 容器会自动注册这个主键 , id为全类名
     *           ImportSelector 返回需要导入的全类名数组 是一个接口
     *           ImportBeanDefinitionRegister
     *4.FactoryBean
     */
    @Bean("person")
    public Person person() {
        System.out.println("给容器添加person.........");
        return new Person("person", 25);
    }

    @Scope("singleton")
    @Bean
    public MyFactoryBean myFactoryBean() {
        return new MyFactoryBean();
    }

}
