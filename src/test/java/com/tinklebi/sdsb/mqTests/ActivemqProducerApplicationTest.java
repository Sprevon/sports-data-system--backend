package com.tinklebi.sdsb.mqTests;

import com.tinklebi.sdsb.config.ActivemqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/15 11:23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ActivemqProducerApplicationTest {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Test
    public void testProducer(){
        String message = "send email to user via ActiveMQ";
        System.out.println(message);
        jmsMessagingTemplate.convertAndSend(ActivemqConfig.TOPIC_EMAIL, message);
    }
}
