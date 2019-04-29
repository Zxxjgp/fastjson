package com.example.fastjson.handle;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoguanping
 * @version 1.0.0(全局異常處理器
 * @ClassName GlobalExceptionHandler
 * @date 2019/4/23  13:55
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Map<String,Object> handlerException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("errorCode",500);
        map.put("errorMsg",e.toString());
        return map;
    }
}
