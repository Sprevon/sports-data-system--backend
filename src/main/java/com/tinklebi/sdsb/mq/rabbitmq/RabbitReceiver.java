package com.tinklebi.sdsb.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.tinklebi.sdsb.config.RabbitmqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/15 10:29
 */
@Component
public class RabbitReceiver {
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void receiveEmail(Object msg, Message message, Channel channel){
        System.out.println("A Receive from " + "message: " + message);
    }

    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_SMS})
    public void receiveSms(Object msg, Message message, Channel channel){
        System.out.println("B Receive from " + "message: " + message);
    }
}
