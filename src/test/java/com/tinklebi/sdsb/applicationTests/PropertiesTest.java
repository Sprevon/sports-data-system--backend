package com.tinklebi.sdsb.applicationTests;

import com.tinklebi.sdsb.config.ApplicationConfig;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/3/27 10:08
 */
@SpringBootTest
public class PropertiesTest {
    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationConfig applicationConfig;

    @Test
    public void testValue(){
        Assertions.assertEquals(dataSourcePassword, "SevenUv7");
    }

    @Test
    public void testEnv(){
        Assertions.assertEquals(environment.getProperty("spring.datasource.password"), "SevenUv7");
    }

    @Test
    public void testConfig(){
        Assertions.assertEquals(applicationConfig.getPassword(), "SevenUv7");
    }

}
