package com.sinodash.sb.logging_default.config.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {
    
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
            throws Exception {
        long startTime = System.currentTimeMillis();
        String userId = request.getHeader("X-User-Id");
        String clientVersion = request.getHeader("X-Client-Version");
        
        logger.info("Request URI: {} | Method: {} | User ID: {} | Client Version: {}", 
                    request.getRequestURI(), request.getMethod(), userId, clientVersion);
        
        MDC.put("requestStartTime", String.valueOf(startTime));
        MDC.put("requestUri", request.getRequestURI());
        MDC.put("userId", userId);
        MDC.put("clientVersion", clientVersion);
        
        return true;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
                               Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        long duration = endTime - Long.parseLong(MDC.get("requestStartTime"));
        
        logger.info("Response Status: {} | Duration: {} ms | User {} | Client {}", response.getStatus(), duration, MDC.get("userId"), MDC.get("clientVersion"));
        
        MDC.clear();
    }
}
