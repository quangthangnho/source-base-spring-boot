package com.thanhquang.sourcebase.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;

@Slf4j
@Component
public class InterceptorConfiguration implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("===== preHandler START =====");
        log.info("Request URL : {}", request.getRequestURI());

        Enumeration<String> headerNames = request.getHeaderNames();

        log.info("===== header value =====");
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            String headerValue = (String) request.getHeader(headerName);
            log.info("{} : {}", headerName, headerValue);
        }
        log.info("=======================");

        return true;
    }
}
