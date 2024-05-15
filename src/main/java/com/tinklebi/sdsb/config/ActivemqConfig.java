package com.tinklebi.sdsb.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTempTopic;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/15 11:20
 */
@Configuration
public class ActivemqConfig {
    public static final String TOPIC_EMAIL = "topic_email";


    @Bean
    public Topic topic(){
        return new ActiveMQTopic(TOPIC_EMAIL);
    }
}
