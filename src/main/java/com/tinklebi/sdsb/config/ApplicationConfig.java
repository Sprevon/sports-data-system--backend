package com.tinklebi.sdsb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/3/27 10:17
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class ApplicationConfig {
    private String password;
}
