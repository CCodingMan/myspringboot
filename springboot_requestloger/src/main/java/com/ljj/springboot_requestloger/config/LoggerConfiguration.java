package com.ljj.springboot_requestloger.config;

import com.ljj.springboot_requestloger.interceptor.LogerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: ljj
 * @Date: 2019/7/8 22:58
 * @Description:
 */
@Configuration
public class LoggerConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogerInterceptor());
    }
}
