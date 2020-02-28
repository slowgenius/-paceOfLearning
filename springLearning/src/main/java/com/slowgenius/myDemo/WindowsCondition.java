package com.slowgenius.myDemo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * @author slowgenius
 * @date 2/27/2020 11:05 PM
 * @description
 */
public class WindowsCondition implements Condition {


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (Objects.requireNonNull(context.getEnvironment().getProperty("os.name")).contains("Windows")) {
            return true;
        }
        return false;
    }
}
