package com.springmvc.ss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lijichen
 * @date 2020/11/24 - 22:57
 */
@Controller
public class TestDemo {
    @Autowired
    private TestService testService;


    public TestDemo() {
        System.out.println("TestDemo....");
    }

    @RequestMapping("/testSSDemo")
    public String testSSDemo() {
        System.out.println(testService);
        return "hello";
    }
}
