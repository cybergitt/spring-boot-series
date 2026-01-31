package com.sinodash.sb.logging_log4j2.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sinodash.sb.logging_log4j2.config.filter.ResponseLoggingFilter;

@Configuration
public class FilterConfig {
    
    @Bean
    public FilterRegistrationBean<ResponseLoggingFilter> loggingFilter() {
        FilterRegistrationBean<ResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ResponseLoggingFilter());
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }
}