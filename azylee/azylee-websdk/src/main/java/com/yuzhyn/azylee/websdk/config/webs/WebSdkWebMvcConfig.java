package com.yuzhyn.azylee.websdk.config.webs;

import com.yuzhyn.azylee.websdk.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSdkWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 日志记录
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
    }
}