package com.tinklebi.sdsb.config;

import com.tinklebi.sdsb.security.filter.FilterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/1/28 20:47
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private FilterConfig filterConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(filterConfig);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://112.124.17.166:8080", "http://www.tinklebi.com:8080", "http://localhost:8080")
                .allowedMethods("GET", "POST")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
