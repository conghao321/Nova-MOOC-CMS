package com.nova.framework.model.response;

/**
 *  to retrieve error code...
 * 10000-- common error code
 * 22000-- media error code
 * 23000-- user center error code
 * 24000-- CMS error code
 * 25000-- file system error code
 */
public interface ResultCode {
    //操作是否成功,true为成功，false操作失败
    boolean success();
    //操作代码
    int code();
    //提示信息
    String message();

}
