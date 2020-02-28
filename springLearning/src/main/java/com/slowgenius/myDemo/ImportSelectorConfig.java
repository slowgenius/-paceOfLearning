package com.slowgenius.myDemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author slowgenius
 * @date 2/27/2020 11:28 PM
 * @description
 */
public class ImportSelectorConfig implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.slowgenius.myDemo.bean.MyImportSelector"};
    }
}
