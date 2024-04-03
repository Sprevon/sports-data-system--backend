package com.tinklebi.sdsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Seven
 */
@SpringBootApplication
public class SdsbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdsbApplication.class, args);
    }

}
