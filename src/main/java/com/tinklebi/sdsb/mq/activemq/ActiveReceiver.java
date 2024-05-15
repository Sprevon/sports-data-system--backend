package com.tinklebi.sdsb.mq.activemq;

import com.tinklebi.sdsb.config.ActivemqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Comments
 * @Author LeonBwChen
 * @Date 2024/5/15 11:26
 */
@Component
public class ActiveReceiver {
    @JmsListener(destination = ActivemqConfig.TOPIC_EMAIL)
    public void receiveMsg(String msg){
        System.out.println("A receive message from ActiveMQ: " + msg);
    }

    @JmsListener(destination = ActivemqConfig.TOPIC_EMAIL)
    public void receiveMsg2(String msg){
        System.out.println("B receive message from ActiveMQ: " + msg);
    }
}
