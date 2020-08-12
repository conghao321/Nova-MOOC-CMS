package com.nova.api.cms;

import com.nova.framework.domain.cms.CmsPage;
import com.nova.framework.domain.cms.request.QueryPageRequest;
import com.nova.framework.domain.cms.response.CmsCode;
import com.nova.framework.domain.cms.response.CmsPageResult;
import com.nova.framework.model.response.QueryResponseResult;
import com.nova.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/*
* Created by Hao Cong
* The Api to perform query operation.
*
* */
@Api(value="cms页面管理接口")
public interface CmsPageControllerApi {

    //Page query
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    //add page
    @ApiOperation("add page")
    public CmsPageResult add(CmsPage cmsPage);

    //query by page id
    @ApiOperation("query page by id")
    public CmsPage findById(String id);


    //edit or update page
    @ApiOperation("edit page info")
    public CmsPageResult edit(String id,CmsPage cmsPage);

    //delete page
    @ApiOperation("delete page")
    public ResponseResult delete(String id);

    //delete page
    @ApiOperation("Post page")
    public ResponseResult post(String id);

    //save page
    @ApiOperation("Post page")
    public CmsPageResult save(CmsPage cmsPage);
}
