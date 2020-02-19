package com.slowgenius.demo.mvc.action;

import com.slowgenius.demo.service.DemoService;
import com.slowgenius.spring.annotation.Autowried;
import com.slowgenius.spring.annotation.Controller;
import com.slowgenius.spring.annotation.RequestMapping;
import com.slowgenius.spring.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author slowgenius
 * @date 2/19/2020 10:03 PM
 * @description
 */

@Controller
@RequestMapping("/demo")
public class DemoAction {
    @Autowried
    private DemoService demoService;

    @RequestMapping("query.json")
    public void query(HttpServletRequest req, HttpServletResponse response,
                      @RequestParam("name") String name) {

        String result = demoService.get(name);
        System.out.println(result);

    }

    @RequestMapping("/edit.json")
    public void edit(HttpServletRequest req, HttpServletResponse response, Integer id) {

    }
}
