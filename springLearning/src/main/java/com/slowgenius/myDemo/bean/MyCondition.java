package com.slowgenius.myDemo.bean;

import com.slowgenius.myDemo.WindowsCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @author slowgenius
 * @date 2/27/2020 11:03 PM
 * @description
 */
@Conditional(WindowsCondition.class)
@Component
public class MyCondition {
}
