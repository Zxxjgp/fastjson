package com.example.fastjson.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Comsumer
 * @date 2019/5/6  22:02
 */
@Component
public class Comsumer {

    //时刻监听消息

    @JmsListener(destination = "")
    public void receiveMsg(String text){

        System.out.println(text+"..............");

    }

}
