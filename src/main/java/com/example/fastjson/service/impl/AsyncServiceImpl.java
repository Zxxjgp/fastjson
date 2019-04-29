package com.example.fastjson.service.impl;

import com.example.fastjson.service.AsyncService;
import freemarker.template.SimpleDate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName AsyncServiceImpl
 * @date 2019/4/23  14:53
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    private static Random random = new Random();



    @Async
    @Override
    public Future<String> doTask1() throws Exception {
        System.out.println("任务一开始执行了");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务一总耗时"+(start - end));
        return new AsyncResult<>("任务一");
    }
    @Async
    @Override
    public Future<String> doTask2() throws Exception {
        System.out.println("任务二开始执行了");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务二总耗时"+(start - end));
        return new AsyncResult<>("任务二");
    }
    @Async
    @Override
    public Future<String> doTask3() throws Exception {
        System.out.println("任务三开始执行了");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务三总耗时"+(start - end));
        return new AsyncResult<>("任务三");
    }

    @Override
    @Scheduled(fixedDelay = 1000)
    public void print() {

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
