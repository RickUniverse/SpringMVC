package com.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lijichen
 * @date 2020/11/24 - 20:34
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 目标方法之前调用
     * 若返回值为true，则继续调用后继的拦截器和目标方法
     * 若返回值为false，则不会继续调用后继的拦截器和目标方法
     * 作用：可以做权限，日志，事务等
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("[MyInterceptor] preHandle");
        return true;
    }

    /**
     * 在目标方法之后被调用,但渲染视图之前
     * 作用：可以对请求域中的属性或试图做出修改
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("[MyInterceptor] postHandle");
    }

    /**
     * 渲染视图之后被调用
     * 作用：释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("[MyInterceptor] afterCompletion");
    }
}
