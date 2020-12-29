package com.springmvc.filters;

import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2020/11/21 - 17:43
 */
public class MyHttpMethodFilter extends HiddenHttpMethodFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String method = httpServletRequest.getMethod();
        if (method.equalsIgnoreCase("delete") || method.equalsIgnoreCase("put")) { method = "POST"; }
        httpServletRequest = new HttpMethodRequestWrapper(request, method);
        filterChain.doFilter(httpServletRequest, response);
    }
    private static class HttpMethodRequestWrapper extends HttpServletRequestWrapper {
        private final String method;
        public HttpMethodRequestWrapper(HttpServletRequest request, String method) {
            super(request);    this.method = method;
        }
        public String getMethod() { return this.method; }
    }
}
