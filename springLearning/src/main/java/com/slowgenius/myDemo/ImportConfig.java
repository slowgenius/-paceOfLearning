package com.slowgenius.myDemo;

import com.slowgenius.myDemo.bean.MyImport;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author slowgenius
 * @date 2/27/2020 11:23 PM
 * @description
 */
public class ImportConfig implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (registry.containsBeanDefinition("sofa")) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(MyImport.class);
            registry.registerBeanDefinition("myImport", beanDefinition);

        }
    }

}
