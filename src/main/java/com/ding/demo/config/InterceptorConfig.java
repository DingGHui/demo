package com.ding.demo.config;

import com.ding.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sun.rmi.runtime.Log;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //需要拦截的路径，/**表示需要拦截所有请求
        String[] addPathPatterns = {"/test"};
        //不需要拦截的路径

        //注册一个登录拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(addPathPatterns)
        ;

    }
}
