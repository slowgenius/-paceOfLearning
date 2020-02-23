package com.slowgenius.cap5.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author slowgenius
 * @date 2/22/2020 1:28 PM
 * @description
 */
public class MyImportSelector implements ImportSelector {

    /**
     * 不能空
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.slowgenius.cap5.bean.Lion", "com.slowgenius.cap5.bean.Fish"};
    }
}
