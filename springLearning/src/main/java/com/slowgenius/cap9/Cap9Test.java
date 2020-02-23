package com.slowgenius.cap9;

import com.slowgenius.cap9.bean.Moon;
import com.slowgenius.cap9.bean.Star;
import com.slowgenius.cap9.bean.Sun;
import com.slowgenius.cap9.config.Cap9MainConfig;
import com.slowgenius.cap9.service.TestService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author slowgenius
 * @date 2/22/2020 8:15 PM
 * @description
 */
public class Cap9Test {

    @Test
    public void test() {
        AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(Cap9MainConfig.class);

/*        for (String beanDefinitionName : anno.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        TestService service = (TestService) anno.getBean("testService");
        Object dao = anno.getBean("testDao");

        System.out.println(service.getTestDao() == dao);*/
        Moon moon = (Moon) anno.getBean("moon");
        System.out.println(moon);
        System.out.println("+++++++++");
        Star star = ((Star) anno.getBean(Star.class));
        System.out.println(star);
    }
}
