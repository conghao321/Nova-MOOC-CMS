package com.nova.framework.exception;
/*
 * @Author:conghao
 * @description: the single and independent exception class to catch the runtime exception.
 *
 *
 */

import com.nova.framework.model.response.ResultCode;

public class CustomizedException extends RuntimeException{

    ResultCode resultCode;

    public CustomizedException(ResultCode resultCode){
        super("errorCode:"+resultCode.code()+"error message:"+resultCode.message());
        this.resultCode=resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }
}
