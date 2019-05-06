package com.example.fastjson.mq;

import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Producter
 * @date 2019/5/6  21:57
 */
@Component
public class Producter {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

/*    @Autowired
    private */

    /**
     * 发送消息
     */
    public void sendMessge(Destination destination, String content){
        jmsMessagingTemplate.convertAndSend( destination,content);
    }
}
