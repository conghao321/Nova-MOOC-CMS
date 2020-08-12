package com.nova.framework.exception;
/*
 * @Author:conghao
 * @description: we use this class to catch the exception uniformly.
 */

import com.google.common.collect.ImmutableMap;
import com.nova.framework.model.response.CommonCode;
import com.nova.framework.model.response.ResponseResult;
import com.nova.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ControllerAdvice
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    //We put different kinds of exception into the map.
    private static ImmutableMap<Class<? extends Throwable>,ResultCode> EXCEPTIONS;
    private static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder=ImmutableMap.builder();

    static {
        //map different exception to different codes.
        builder.put(HttpMessageNotReadableException.class,CommonCode.INVALID_PARAM);

    }

    //捕获 CustomException异常
    @ExceptionHandler(CustomizedException.class)
    @ResponseBody
    public ResponseResult customException(CustomizedException e) {
        LOGGER.error("catch exception : {}",e.getMessage());
        ResultCode resultCode = e.getResultCode();
        ResponseResult responseResult = new ResponseResult(resultCode);
        return responseResult;
    }

    //捕获 RuntimeException异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception e) {
        LOGGER.error("catch exception : {}",e.getMessage());
        if(EXCEPTIONS.size()==0){
            builder.build();
        }

        ResultCode resultCode=EXCEPTIONS.get(e);
        if(resultCode!=null)
            return new ResponseResult(resultCode);
        else
            return new ResponseResult(CommonCode.SERVER_ERROR);
    }

}
