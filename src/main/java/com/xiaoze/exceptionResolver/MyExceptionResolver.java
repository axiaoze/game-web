package com.xiaoze.exceptionResolver;

import com.xiaoze.exception.MyException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 自定义异常处理器
 */
//拦截异常
//@ControllerAdvice
//@ResponseBody
@RestControllerAdvice
public class MyExceptionResolver {
    //指定处理哪个异常
    @ExceptionHandler(MyException.class)
    //返回的http状态码
    @ResponseStatus
    public Map<String,Object> handlerException(MyException e){
        return null;
    }
}
