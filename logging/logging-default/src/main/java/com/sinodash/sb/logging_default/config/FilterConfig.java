package com.sinodash.sb.logging_default.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sinodash.sb.logging_default.config.filter.ResponseLoggingFilter;

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