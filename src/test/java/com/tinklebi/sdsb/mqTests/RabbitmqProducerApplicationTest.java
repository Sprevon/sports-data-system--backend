package com.tinklebi.sdsb.mqTests;

import com.tinklebi.sdsb.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/15 10:24
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitmqProducerApplicationTest {
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 参数：
     * 1、交换机名称
     * 2、routingKey
     * 3、消息内容
     */
    @Test
    public void producerTest(){
        String message = "send email message to user";
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM, "inform.email", message);
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM, "inform.sms", message);
        System.out.println(message);

//        String sms = "send sms message to user";
//        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM, "inform.sms", message);
//        System.out.println(sms);
    }

}
