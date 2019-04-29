package com.example.fastjson.service;

/**
 * @ProjectName: fastjson
 * @Package: com.example.fastjson.service
 * @ClassName: MailService
 * @Author: jgp
 * @Description: ${DESCRIPTION}
 * @Date: 2019/4/29 19:32
 * @Version: 1.0
 */
public interface MailService {
    void sendMail(String sendTo, String title , String content);
}
