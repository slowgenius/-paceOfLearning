package com.slowgenius.cap2.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author slowgenius
 * @date 2/21/2020 8:45 PM
 * @description
 */


public class CustomFilter implements TypeFilter {

    private ClassMetadata classMetadata;
    /**
     * @param metadataReader        读取到当前正在扫描类的信息
     * @param metadataReaderFactory 可以获取到其他任何类信息
     * @return
     * @description
     * @date 2/21/2020 8:47 PM
     * @author slowgenius
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类信息
        classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源(类的路径)
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println(className);

        if (className.contains("dao")) {
            return true;
        }
        return false;
    }
}
