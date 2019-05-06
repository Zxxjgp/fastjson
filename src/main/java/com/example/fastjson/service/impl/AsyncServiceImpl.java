package com.example.fastjson.service.impl;

import com.example.fastjson.config.RedisUtils;
import com.example.fastjson.dao.AreaDao;
import com.example.fastjson.domain.CardBindEntity;
import com.example.fastjson.domain.Test;
import com.example.fastjson.mapper.UserDao;
import com.example.fastjson.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserDao userDao;

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
   // @Scheduled(fixedDelay = 1000)
    public void print() {
      /*  System.out.println("****"+userDao.getList());
        System.out.println("===="+areaDao.getLists());*/

        System.out.println(areaDao.getAddressByCode("10"));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addTest() {
        userDao.addTest("5","测试数据");
        int x =5 /0;
    }

    @Override
    public void addJpaTest(Test test) {

    }

    @Override
    public CardBindEntity qryCardBind(String cardNo) {
        System.out.println("数据");

        redisUtils.set("jj","qewewewe",30);
        CardBindEntity cardBindEntity = null;
        return cardBindEntity;
    }
}
