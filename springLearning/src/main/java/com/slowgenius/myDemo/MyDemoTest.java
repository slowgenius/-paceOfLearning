package com.slowgenius.myDemo;

import com.slowgenius.myDemo.bean.MyBeanFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author slowgenius
 * @date 2/27/2020 10:44 PM
 * @description
 */
public class MyDemoTest {

    private AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(MyDemoConfig.class);


    /**
     * 配置类扫描
     */
    @Test
    public void test1() {
        for (String beanDefinitionName : anno.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

    }

    @Test
    public void testScope(){
        Object myScope = anno.getBean("myScope");
        Object myScope2 = anno.getBean("myScope");
        System.out.println(myScope == myScope2);

    }

    @Test
    public void testLazy() {
        System.out.println("initialize bean completed");
        anno.getBean("myLazy");
    }


    @Test
    public void testCondition() {
        for (String beanDefinitionName : anno.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void testBeanFactory() {
        Object factory = ((MyBeanFactory) anno.getBean("myBeanFactory"));
        System.out.println(factory.getClass());
        System.out.println(factory instanceof MyBeanFactory);

    }

    @Test
    public void testImportBean() {
        System.out.println(anno.getBean("myImport"));
    }

    @Test
    public void testImportSelector() {
        System.out.println(anno.getBean("com.slowgenius.myDemo.bean.MyImportSelector"));
    }
}
