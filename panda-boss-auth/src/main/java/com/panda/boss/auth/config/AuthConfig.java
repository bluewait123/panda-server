package com.panda.boss.auth.config;

import com.panda.boss.auth.interceptor.AuthResourceInterceptor;
import com.panda.boss.auth.interceptor.SessionUserInfoResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * AUTH 配置
 * 1.配置拦截器
 * 2.配置用户信息拦截器，压入用户信息
 * @author w
 * @date 2020-07-1
 */
@Configuration
public class AuthConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthInterceptor()).excludePathPatterns("/", "/error").addPathPatterns("/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(getCurrentSessionResolver());
    }

    @Bean
    public HandlerInterceptor getAuthInterceptor() {
        return new AuthResourceInterceptor();
    }

    @Bean
    public HandlerMethodArgumentResolver getCurrentSessionResolver() {
        return new SessionUserInfoResolver();
    }
}
