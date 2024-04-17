package com.tinklebi.sdsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Seven
 */
@SpringBootApplication
@EnableJpaRepositories
public class SdsbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdsbApplication.class, args);
    }

}
