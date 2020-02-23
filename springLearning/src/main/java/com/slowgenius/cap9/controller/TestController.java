package com.slowgenius.cap9.controller;

import com.slowgenius.cap9.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author slowgenius
 * @date 2/22/2020 8:09 PM
 * @description
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;
}
