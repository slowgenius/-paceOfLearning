package com.slowgenius.cap1;

import com.slowgenius.cap1.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author slowgenius
 * @date 2/21/2020 7:38 PM
 * @description
 */
public class Test {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        Person person = (Person) applicationContext.getBean("person");


        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        Person person1 = (Person) annotationConfigApplicationContext.getBean("person1");

        System.out.println(person1);

        System.out.println(person);
    }
}
