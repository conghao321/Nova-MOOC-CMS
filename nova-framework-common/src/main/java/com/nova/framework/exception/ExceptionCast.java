package com.nova.framework.exception;
/*
 * @Author:conghao
 * @description:
 */

import com.nova.framework.model.response.ResultCode;

public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomizedException(resultCode);
    }
}
