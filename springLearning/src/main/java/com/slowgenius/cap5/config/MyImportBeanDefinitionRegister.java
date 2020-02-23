package com.slowgenius.cap5.config;

import com.slowgenius.cap5.bean.Pig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author slowgenius
 * @date 2/22/2020 1:41 PM
 * @description
 */
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    /**
     * @param importingClassMetadata 当前类的注解信息
     * @param registry               BeanDefinition的注册类 把所有需要添加到容器中的bean加入
     * @return
     * @description
     * @date 2/22/2020 1:43 PM
     * @author slowgenius
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean containsBeanDefinition = registry.containsBeanDefinition("com.slowgenius.cap5.bean.Dog");
        boolean containsBeanDefinition1 = registry.containsBeanDefinition("com.slowgenius.cap5.bean.Cat");
        if (containsBeanDefinition && containsBeanDefinition1) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig",beanDefinition);
        }
    }
}
