package com.example.fastjson.web;

import com.example.fastjson.domain.CardBindEntity;
import com.example.fastjson.domain.Person;
import com.example.fastjson.domain.Test;
import com.example.fastjson.mq.Producter;
import com.example.fastjson.service.AsyncService;
import com.example.fastjson.service.MailService;
import com.example.fastjson.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestController
 * @date 2019/4/23  11:43
 */
@Controller
@Api(value = "首页", description = "首页" , tags = {"text"})
public class TestController {

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private Producter producter;

    @Autowired
    private FileUtils fileUtils;

    @Autowired
    private MailService mailService;

    @GetMapping("index")
    public Person get(){
        Person ren = new Person();
        ren.setId(12);
        ren.setName("中国人");
        ren.setDate(new Date());
        return ren;
    }


    @GetMapping("exception")
    public String  exception(){

        int t = 5/0;
        return String.valueOf(t);
    }

    @GetMapping("async")
    public String  async() throws Exception {

        long start = System.currentTimeMillis();
        Future<String> task1 = asyncService.doTask1();
        Future<String> task2 = asyncService.doTask2();
        Future<String> task3 = asyncService.doTask3();

        while (true) {
            if ( task1.isDone() && task2.isDone() && task3.isDone() ) {
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        return "全部执行完成"+(start -end)+"毫秒";
    }

    @GetMapping("jsp")
    public String jsp(){
        return "index";
    }


    @GetMapping("free")
    public String  free(Model model){
        model.addAttribute("name","中国人");

        return "freemarker";
    }

    @GetMapping("thy")
    @ApiOperation(value = "测试thyem模板引擎")
    public String  thy(Model model){
        model.addAttribute("them","测试数据");

        return "them";
    }
    @GetMapping("more")
    @ApiOperation(value = "测试thyem模板引擎")
    public String  more(Model model){
       /* asyncService.print();
        model.addAttribute("them","测试数据");*/
        asyncService.addTest();
        return "them";
    }
    @GetMapping("jpa")
    @ApiOperation(value = "测试jpa")
    public String  jpa(Model model){
        Test test = new Test();
        test.setId(2);
        test.setName("测试类");
        asyncService.addJpaTest(test);
        return "them";
    }

    @GetMapping("mail")
    public String sendMail(){
    //    mailService.sendMail("948102903@qq.com","你好，","明天去你家");
        asyncService.print();
        return "them";
    }
    @PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file , HttpServletRequest request){
        String s = fileUtils.upLoad(file, request);
        return s;
    }
    @GetMapping("qryCardBind")
    @ResponseBody
    public CardBindEntity qryCardBind(String accNo){
        return asyncService.qryCardBind(accNo);
    }

    ////////////////////////////////////////////////////////////
    @GetMapping("/sendMessageMq")
    public String sendMessageMq(){
        Destination destination = new ActiveMQQueue("myQueues");
            producter.sendMessge(destination,"测试消息");
        return "" ;
    }
}
