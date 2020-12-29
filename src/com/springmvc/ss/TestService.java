package com.springmvc.ss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lijichen
 * @date 2020/11/24 - 22:56
 */
@Service
public class TestService {

    /**
     * Spring层IOC不可自动注解使用SpringMVC层bean
     */
//    @Autowired
//    private TestDemo testDemo;
    public TestService(){
        System.out.println("TestService。。。。");
    }
}
