package com.example.fastjson.service;

import java.util.concurrent.Future;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName AsyncService
 * @date 2019/4/23  14:52
 */
public interface AsyncService {
    Future<String> doTask1() throws Exception;
    Future<String> doTask2() throws Exception;
    Future<String> doTask3() throws Exception;

    void  print();
}
