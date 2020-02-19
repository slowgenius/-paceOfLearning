package com.slowgenius.demo.service.impl;

import com.slowgenius.demo.service.DemoService;
import com.slowgenius.spring.annotation.Service;

/**
 * @author slowgenius
 * @date 2/19/2020 10:05 PM
 * @description
 */

@Service
public class DemoServiceImpl implements DemoService {

    public String get(String name) {
        return "My name is " + name;
    }
}
