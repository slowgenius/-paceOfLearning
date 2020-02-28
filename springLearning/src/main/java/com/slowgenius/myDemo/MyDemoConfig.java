package com.slowgenius.myDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author slowgenius
 * @date 2/27/2020 10:43 PM
 * @description
 */

@Configuration
@ComponentScan
@Import({ImportConfig.class,ImportSelectorConfig.class})
public class MyDemoConfig {

}
