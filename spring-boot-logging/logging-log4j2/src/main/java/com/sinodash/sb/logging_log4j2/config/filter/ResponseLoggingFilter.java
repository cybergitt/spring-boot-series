package com.sinodash.sb.logging_log4j2.config.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ResponseLoggingFilter implements Filter {
    
    private static final Logger logger = LoggerFactory.getLogger(ResponseLoggingFilter.class);
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) response);
        
        chain.doFilter(request, responseWrapper);
        
        logger.info("Response Status: {} | Body Length: {} bytes", 
                    responseWrapper.getStatus(), 
                    responseWrapper.getResponseData().length);
    }
}