package com.example.fastjson.web;

import com.example.fastjson.domain.Person;
import com.example.fastjson.service.AsyncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
