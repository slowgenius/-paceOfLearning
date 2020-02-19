package com.slowgenius.demo.mvc.action;

import com.slowgenius.demo.service.DemoService;
import com.slowgenius.spring.annotation.Autowried;
import com.slowgenius.spring.annotation.Controller;
import com.slowgenius.spring.annotation.RequestMapping;

/**
 * @author slowgenius
 * @date 2/19/2020 10:10 PM
 * @description
 */
@Controller
public class MyAction {
    @Autowried
    private DemoService demoService;

    @RequestMapping("/index.html")
    public void query() {

    }
}
