package com.example.fastjson;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sound.midi.Soundbank;
import java.util.List;

@SpringBootApplication
@EnableAsync
@EnableSwagger2
@EnableScheduling
public class FastjsonApplication {


    /**
     * 消息转换器
     * @return
     */
    @Bean
    public HttpMessageConverters fastJson(){
        //消息转换器
        FastJsonHttpMessageConverter fast = new FastJsonHttpMessageConverter();

        //配置对象
        FastJsonConfig fs = new FastJsonConfig();

        fs.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fast.setFastJsonConfig(fs);
        HttpMessageConverter<?> con = fast;
        return new HttpMessageConverters(con);
    }


    public static void main(String[] args) {
        SpringApplication.run(FastjsonApplication.class, args);
    }

}
