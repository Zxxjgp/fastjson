package com.example.fastjson.service.impl;

import com.example.fastjson.service.MailService;
import com.example.fastjson.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: fastjson
 * @Package: com.example.fastjson.service.impl
 * @ClassName: MailServiceImpl
 * @Author: jgp
 * @Description: ${DESCRIPTION}
 * @Date: 2019/4/29 19:34
 * @Version: 1.0
 */
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private MailUtils mailUtils;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail(String sendTo, String title, String content) {
        //简单邮件的发送

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailUtils.getEmailFrom());
        simpleMailMessage.setTo(sendTo);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(content);
        javaMailSender.send(simpleMailMessage);

    }
}
