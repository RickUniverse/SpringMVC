package com.springmvc.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lijichen
 * @date 2020/11/24 - 21:15
 */
@ControllerAdvice
public class HandlerException {

    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView testExceptionHandler(Exception ex) {
        System.out.println(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("forward:/views/errors/error.jsp");
        modelAndView.addObject("exception",ex);
        return modelAndView;
    }
}
