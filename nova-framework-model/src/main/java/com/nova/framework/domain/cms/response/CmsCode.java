package com.nova.framework.domain.cms.response;

import com.nova.framework.model.response.ResultCode;
import lombok.ToString;

/**
 * Created by mrt on 2020/3/5.
 */
@ToString
public enum CmsCode implements ResultCode {


    CMS_ADDPAGE_EXISTSNAME(false,24001,"Page name already existed!"),
    CMS_GENERATEHTML_DATAURLISNULL(false,24002,"从页面信息中找不到获取数据的url！"),
    CMS_GENERATEHTML_DATAISNULL(false,24003,"根据页面的数据url获取不到数据！It cannot fetch the data by the page's url!"),
    CMS_GENERATEHTML_TEMPLATEISNULL(false,24004,"The page template is empty!"),
    CMS_GENERATEHTML_HTMLISNULL(false,24005,"生成的静态html为空！Produced static page is null!"),
    CMS_GENERATEHTML_SAVEHTMLERROR(false,24006,"保存静态html出错！ There is something error when saving static html"),
    CMS_COURSE_PERVIEWISNULL(false,24007,"预览页面为空！The preview page is empty"),
    CMS_PAGE_NOTEXISTS(false,24008,"页面不存在！The page doesn't exist..."),
    INVALID_PARAM(false,24009,"Params are error");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CmsCode(boolean success, int code, String message){
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
