package com.nova.framework.exception;
/*
 * @Author:conghao
 * @description:
 * This class is used to catch some common error or exception
 */

import com.nova.framework.model.response.ResultCode;

public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomizedException(resultCode);
    }
}
