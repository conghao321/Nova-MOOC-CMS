package com.nova.framework.model.response;

import lombok.ToString;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */

@ToString
public enum CommonCode implements ResultCode{



    SUCCESS(true,10000,"Operation Succeed！"),
    FAIL(false,11111,"Operation Failed！"),
    UNAUTHENTICATED(false,10001,"This operation requires you to login"),
    UNAUTHORISE(false,10002,"You have no authority, please check it by sudo."),
    SERVER_ERROR(false,99999,"Sorry, the system is busy, please try it lager"),
    CMS_ADDPAGE_EXISTS(false,24001,"The page already exist!"),
    INVALID_PARAM(false,10003,"The input params are invalid");

    //private static ImmutableMap<Integer, CommonCode> codes ;
    //flag for success or not
    boolean success;

    //operation's code
    int code;

    //the return message and hints
    String message;

    private CommonCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }



}
