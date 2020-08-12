package com.nova.framework.domain.cms.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/*
Author: Hao Cong

to receive the query for page id.
*/
@Data
public class QueryPageRequest {

    @ApiModelProperty("站点id")
    private String siteId;
    //页面ID
    @ApiModelProperty("页面ID")
    private String pageId;
    //页面名称
    @ApiModelProperty("页面名称")
    private String pageName;
    // 页面别名
    @ApiModelProperty("页面别名")
    private String pageAliase;
    // 模版id
    @ApiModelProperty("模版id")
    private String templateId;
}
