package com.ftf.naming.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftf.naming.biz.HttpResult;
import com.ftf.naming.biz.enums.ResultCode;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler  //处理其他异常
    @ResponseBody
    public HttpResult allExceptionHandler(Exception e){
        log.error("未捕获异常",e);
        return new HttpResult(ResultCode.FAILED);
    }
}
