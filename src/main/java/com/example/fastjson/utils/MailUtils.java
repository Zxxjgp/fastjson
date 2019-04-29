package com.example.fastjson.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: fastjson
 * @Package: com.example.fastjson.utils
 * @ClassName: MailUtils
 * @Author: jgp
 * @Description: ${DESCRIPTION}
 * @Date: 2019/4/29 19:28
 * @Version: 1.0
 */
@Data
@Component
public class MailUtils {
    @Value("${spring.mail.username}")
    private String emailFrom;

}
